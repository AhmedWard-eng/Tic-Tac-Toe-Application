/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import com.sun.jndi.dns.DnsContextFactory;
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
import static tictactoegame.FXMLLoginBase.playerOneName;

/**
 *
 * @author AhmedWard
 */
public class NetworkConnection {

    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintStream ps;
    private static NetworkConnection networkConnection;

    public static NetworkConnection getInstance() {
        if (networkConnection == null) {
            networkConnection = new NetworkConnection();
        }
        return networkConnection;
    }

    private NetworkConnection() {
        try {
            //"10.145.19.104"
            socket = new Socket(InetAddress.getLocalHost(), 5005);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ps = new PrintStream(socket.getOutputStream());
            readMessage();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void readMessage() {
        RepeatedUserDialog r = new RepeatedUserDialog();
        new Thread() {
            @Override
            public void run() {
                try {
                    while (socket.isConnected()) {
                        String str = bufferedReader.readLine();
                        System.out.println("client recivedddddddddddddddddddddddddddddddd= " + str);
                        JsonReader jsonReader = (JsonReader) Json.createReader(new StringReader(str));
                        JsonObject object = jsonReader.readObject();
                        System.out.println("operationnnnnnnn"+object.getString("operation"));
                        System.out.println("client recivedddddddddddddddddddddddddddddddd= " + str);
                        if (str.equals("Exist username")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    r.ExistDialog();
                                }
                            });
//commment
                        }else if (str.equals("invalid data! please try to login again..") || str.equals("this username is not reistered")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    r.loginUnsuccessDialog(str);
                                }
                            });

                        }else if (str.equals("login successfully")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    Stage stage = TicTacToeGame.getStage();
                                    Navigation.navigate(stage, new FXMLAvailableUsersBase(stage));
                                }
                            });

                        }
                        if (object.getString("operation").equals("loginResponse")) {
                            if (object.getString("msg").equals("Invalid data! please try to login again..") || object.getString("msg").equals("This username is not reistered")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    FXMLLoginBase.playerOneName =null;
                                    r.loginUnsuccessDialog(object.getString("msg"));
                                }
                            });

                        }else if (object.getString("msg").equals("login successfully")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    //FXMLLoginBase.playerOneName = TextFieldUserName.getText();
                                    Stage stage = TicTacToeGame.getStage();
                                    Navigation.navigate(stage, new FXMLAvailableUsersBase(stage));
                                }
                            });

                        }
                        }
                        
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();

                }
            }
        }.start();
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
