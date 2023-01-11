/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import beans.RequestGameBean;
import com.google.gson.Gson;
import game.Seed;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import javafx.stage.Stage;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import navigationLogic.Navigation;

/**
 *
 * @author AhmedWard
 */
public class NetworkConnection {

    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintStream ps;
    private static NetworkConnection networkConnection;

    RepeatedUserDialog r;
    String message;

    public static NetworkConnection getInstance() {
        if (networkConnection == null) {
            networkConnection = new NetworkConnection();
        }
        return networkConnection;
    }

    private NetworkConnection() {
        try {
            socket = new Socket(InetAddress.getLocalHost(), 5005);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ps = new PrintStream(socket.getOutputStream());
            r = new RepeatedUserDialog();
            readMessage();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void readMessage() {
        new Thread() {
            @Override
            public void run() {

                try {
                    while (socket.isConnected()) {

                        message = bufferedReader.readLine();

                        message = message.replaceAll("\r?\n", "");
                        JsonReader jsonReader = (JsonReader) Json.createReader(new StringReader(message));
                        JsonObject object = jsonReader.readObject();

//                        System.out.println("client recivedddddddddddddddddddddddddddddddd= " + message);
                        if (object.getString("operation").equals("signup")) {
                            String str = object.getString("message");
                            if (str.equals("notExist")) {
                                System.out.println("Sign Up succeded");
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        r.dialogSignUp();
                                    }
                                });
                            } else {
                                System.out.println("Sign Up Failed repeated");
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        r.dialogRepeated();
                                    }
                                });
                            }
                        } else if (message.equals("invalid data! please try to login again..") || message.equals("this username is not reistered")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    r.loginUnsuccessDialog(message);
                                }
                            });

                        } else if (message.equals("login successfully")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    Stage stage = TicTacToeGame.getStage();
                                    Navigation.navigate(stage, new FXMLAvailableUsersBase(stage));
                                }
                            });

                        } else if (object.getString("operation").equals("requestPlaying")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    RepeatedUserDialog.acceptPlaying(NetworkConnection.this, new Gson().fromJson(message, RequestGameBean.class));
                                }
                            });

                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();

                }
            }
        }
                .start();
    }

    public void sendMessage(String message) {
        new Thread() {
            @Override
            public void run() {
                ps.println(message);
            }
        }.start();
    }
}
