/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import beans.RequestGameBean;
import com.google.gson.Gson;
import game.Seed;
import beans.UserOnline;
import beans.UsersResponseBean;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.sun.jndi.dns.DnsContextFactory;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

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
    private String ip;

    RepeatedUserDialog r;
    String message;

    public static ArrayList<UserOnline> list;

    public static NetworkConnection getInstance() {
        if (networkConnection == null) {
            networkConnection = new NetworkConnection();
        }
        return networkConnection;
    }

    private NetworkConnection() {
        try {
            //"10.145.19.104"

            socket = new Socket("192.168.1.8", 5005);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ps = new PrintStream(socket.getOutputStream());
            ip = socket.getInetAddress().getHostAddress();
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
                        list = new ArrayList<>();
                        JsonParser jsonParser = new JsonParser();
//                        JsonArray jsonArray = (JsonArray) jsonParser.parse(message);
//                        for (int i = 0; i < jsonArray.size(); i++) {
//                            UserOnline p = new Gson().fromJson(jsonArray.get(i).toString(), UserOnline.class);
//                            list.add(p);
//                            System.out.println("done.." + p.getUserName());
//                            System.out.println("CCCCCCCCLLIInt" + list.toString());
//                        }
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
                        } else if (object.getString("operation").equals("loginResponse")) {
                            if (object.getString("msg").equals("Invalid data! please try to login again..") || object.getString("msg").equals("This username is not reistered")) {
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        FXMLLoginBase.playerOneName = null;
                                        r.loginUnsuccessDialog(object.getString("msg"));
                                    }
                                });

                            } else if (object.getString("msg").equals("login successfully")) {
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        //FXMLLoginBase.playerOneName = TextFieldUserName.getText();
//                                        Stage stage = TicTacToeGame.getStage();
//                                        Navigation.navigate(stage, new FXMLAvailableUsersBase(stage));
                                    }
                                });

                            }
                        } else if (object.getString("operation").equals("onlineList")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    System.out.println(message);
                                    UsersResponseBean usersResponseBean = new Gson().fromJson(message, UsersResponseBean.class);
                                    System.out.println("users" + usersResponseBean.getUsers().size());
                                    Stage stage = TicTacToeGame.getStage();
                                    Navigation.navigate(stage, new FXMLAvailableUsersBase(stage, usersResponseBean.getUsers()));
                                }
                            });
                        } else if (object.getString("operation").equals("requestPlaying")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    RequestGameBean requestGameBean = new Gson().fromJson(message, RequestGameBean.class);
                                    RepeatedUserDialog.acceptPlaying(networkConnection, requestGameBean);
                                }
                            });
                        } else if (object.getString("operation").equals("accept")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    RequestGameBean requestGameBean = new Gson().fromJson(message, RequestGameBean.class);
                                    Stage stage = TicTacToeGame.getStage();
                                    Navigation.navigate(stage, new FXMLGameOnlineBase(stage, requestGameBean));
                                }
                            });
                        } else if (object.getString("operation").equals("refuse")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    RequestGameBean requestGameBean = new Gson().fromJson(message, RequestGameBean.class);
                                    RepeatedUserDialog.acceptPlaying(networkConnection, requestGameBean);
                                }
                            });
                        }
         

//////
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

    public String getIp() {
        return ip;
    }
}
