/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import beans.GameBean;
import beans.LoginResponseBean;
import beans.RequestGameBean;
import com.google.gson.Gson;
import game.Seed;
import beans.UserOnline;
import beans.UsersResponseBean;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
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

    private static Socket socket;
    private static BufferedReader bufferedReader;
    private static PrintStream ps;
    private String ip;

    RepeatedUserDialog r;
    String message;
    private static OnlineGameMove onlineGameMove;

//    public static NetworkConnection getInstance() {
//        if (networkConnection == null) {
//            networkConnection = new NetworkConnection();
//        }
//        return networkConnection;
//    }
//    public static NetworkConnection getInstance(OnlineGameMove onlineGameMove) {
//        if (networkConnection == null) {
//            networkConnection = new NetworkConnection();
//        }
//        ogm = onlineGameMove;
//        return networkConnection;
//
//    }
    public NetworkConnection() {
        try {
            //"10.145.19.104"
            if (socket == null || !socket.isConnected() || socket.isClosed()) {
                socket = new Socket("192.168.1.3", 5005);
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                ps = new PrintStream(socket.getOutputStream());
            }

            ip = socket.getLocalAddress().getHostAddress();
            r = new RepeatedUserDialog();

            readMessage();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public NetworkConnection(OnlineGameMove onlineGameMove) {
        try {
            //"10.145.19.104"
            if (socket == null || !socket.isConnected() || socket.isClosed()) {
                socket = new Socket("192.168.1.5", 5005);
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                ps = new PrintStream(socket.getOutputStream());
            }

            ip = socket.getLocalAddress().getHostAddress();
            NetworkConnection.onlineGameMove = onlineGameMove;
//            System.out.println("heeh the onlineGame move is not null" + onlineGameMove);
//            System.out.println(ip);
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
                        System.out.println("message in network connection" + message);

                        JsonReader jsonReader = (JsonReader) Json.createReader(new StringReader(message));
                        JsonObject object = jsonReader.readObject();
                        JsonParser jsonParser = new JsonParser();
                        System.out.println("operationnnnnnnnnnnnnnnnnnnnnnn"+object.getString("operation"));
//                        JsonArray jsonArray = (JsonArray) jsonParser.parse(message);
//                        for (int i = 0; i < jsonArray.size(); i++) {
//                            UserOnline p = new Gson().fromJson(jsonArray.get(i).toString(), UserOnline.class);
//                            list.add(p);
//                            System.out.println("done.." + p.getUserName());
//                            System.out.println("CCCCCCCCLLIInt" + list.toString());
//                        }
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
                                        LoginResponseBean loginResponseBean = new Gson().fromJson(message, LoginResponseBean.class);
                                        //FXMLLoginBase.playerOneName = TextFieldUserName.getText();
                                        Stage stage = TicTacToeGame.getStage();
                                        Navigation.navigate(stage, new FXMLAvailableUsersBase(stage, loginResponseBean.getUsers()));
                                    }
                                });

                            }
                        } else if (object.getString("operation").equals("onlineList")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
//                                    System.out.println("mmmmmmmmmmmmmesssssaggggeeee"+message);
                                    UsersResponseBean usersResponseBean = new Gson().fromJson(message, UsersResponseBean.class);

//                                    System.out.println("users" + usersResponseBean.getUsers().size());
                                    Stage stage = TicTacToeGame.getStage();
                                    //TODO
                                    Navigation.navigate(stage, new FXMLAvailableUsersBase(stage, usersResponseBean.getUsers()));
                                }
                            });
                        } else if (object.getString("operation").equals("requestPlaying")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    Stage stage = TicTacToeGame.getStage();
                                    RequestGameBean requestGameBean = new Gson().fromJson(message, RequestGameBean.class);
                                    RepeatedUserDialog.acceptPlaying(NetworkConnection.this, requestGameBean, stage);
                                }
                            });
                        } else if (object.getString("operation").equals("accept")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    RequestGameBean requestGameBean = new Gson().fromJson(message, RequestGameBean.class);
                                    Stage stage = TicTacToeGame.getStage();
                                    Navigation.navigate(stage, new FXMLGameOnlineBase(stage, requestGameBean, true));
                                }
                            });
                        } else if (object.getString("operation").equals("refuse")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    RequestGameBean requestGameBean = new Gson().fromJson(message, RequestGameBean.class);
                                    RepeatedUserDialog.dialogRefuse(requestGameBean);
                                }
                            });
                        } else if (object.getString("operation").equals("gameMove")) {
                            GameBean gamebean = new Gson().fromJson(message, GameBean.class);

                            System.out.println("cellllllllllllllllllllllllllllll" + gamebean.cell.content.getIcon());
                            
                            System.out.println("online game = " + onlineGameMove);
                            if (onlineGameMove != null) {
                                System.out.println(gamebean.cell.content.getIcon());
                                onlineGameMove.getMove(gamebean.cell);
                            }

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
