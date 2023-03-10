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
import interfaces.OnlineUsersList;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
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
    public static ArrayList<UserOnline> users;
    private String ip;
    public static UserOnline userOnline;

    public Socket getSocket() {
        return socket;
    }

    RepeatedUserDialog r;
    String message;
    private static OnlineGameMove onlineGameMove;
    private static OnlineUsersList onlineUsersList;

    public NetworkConnection() {
        try {
            //"10.145.19.104"
            if (socket == null || !socket.isConnected() || socket.isClosed()) {

                socket = new Socket("10.145.19.104", 5005);


                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                ps = new PrintStream(socket.getOutputStream());
                readMessage();
            }

            ip = socket.getLocalAddress().getHostAddress();
            r = new RepeatedUserDialog();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public NetworkConnection(OnlineUsersList onlineUsersList) {
        try {
            //"10.145.19.104"
            if (socket == null || !socket.isConnected() || socket.isClosed()) {

                socket = new Socket("10.145.19.104", 5005);


                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                ps = new PrintStream(socket.getOutputStream());

                readMessage();
            }

            ip = socket.getLocalAddress().getHostAddress();
            r = new RepeatedUserDialog();

            NetworkConnection.onlineUsersList = onlineUsersList;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public NetworkConnection(OnlineGameMove onlineGameMove) {
        try {
            //"10.145.19.104"
            if (socket == null || !socket.isConnected() || socket.isClosed()) {

                socket = new Socket("10.145.19.104", 5005);


                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                ps = new PrintStream(socket.getOutputStream());
                readMessage();
            }

            ip = socket.getLocalAddress().getHostAddress();
            NetworkConnection.onlineGameMove = onlineGameMove;
//            System.out.println("heeh the onlineGame move is not null" + onlineGameMove);
//            System.out.println(ip);
            r = new RepeatedUserDialog();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public NetworkConnection(String testMsg) throws IOException {
        //"10.145.19.104"
        if (socket != null) {
            socket.close();
        }
        socket = null;
        if (socket == null || socket.isClosed()) {

            socket = new Socket("10.145.19.104", 5005);


            System.out.println("tictactoegame.NetworkConnection.<init>() in constructor testmsg");
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ps = new PrintStream(socket.getOutputStream());
            readMessage();
        }
        System.out.println("tictactoegame.NetworkConnection.<init>() in constructor testmsg" + socket.isConnected());
//            System.out.println(ip);
        ip = socket.getLocalAddress().getHostAddress();
        r = new RepeatedUserDialog();

    }

    public void readMessage() {

        new Thread() {
            @Override
            public void run() {

                try {
                    while (socket.isConnected() && !socket.isClosed()) {

                        message = bufferedReader.readLine();

                        if (message == null) {
                            System.out.println(".runnnnnnnnnnn()");
                            r.dialogOutOfConnection();
                            socket.close();
                            break;
                        }

                        message = message.replaceAll("\r?\n", "");

                        System.out.println("message in network connection" + message);

                        JsonReader jsonReader = (JsonReader) Json.createReader(new StringReader(message));
                        JsonObject object = jsonReader.readObject();
                        JsonParser jsonParser = new JsonParser();
                        System.out.println("operationnnnnnnnnnnnnnnnnnnnnnn" + object.getString("operation"));
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
//                                        r.dialogSignUp();
                                        RepeatedUserDialog.dialogSinUpSuss();
                                    }
                                });
                            } else {
                                System.out.println("Sign Up Failed repeated");
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
//                                        r.dialogRepeated();
                                        RepeatedUserDialog.dialogSinUp("Sorry repeated username.");
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
                                        userOnline = new UserOnline(ip, loginResponseBean.getUserName(), "", "", loginResponseBean.getScore());
                                        Navigation.navigate(stage, new FXMLAvailableUsersBase(stage, removeMeFromList(loginResponseBean.getUsers())));
                                    }
                                });

                            }
                        } else if (object.getString("operation").equals("onlineList")) {
//                            Platform.runLater(new Runnable() {
//                                @Override
//                                public void run() {
                            System.out.println("message" + message);
                            UsersResponseBean usersResponseBean = new Gson().fromJson(message, UsersResponseBean.class);

                            System.out.println("first Users");
                            if (onlineUsersList != null) {
                                onlineUsersList.getUsers(removeMeFromList(usersResponseBean.getUsers()));
                                NetworkConnection.users = removeMeFromList(usersResponseBean.getUsers());
                            }
//                                    Stage stage = TicTacToeGame.getStage();

//                                    Navigation.navigate(stage, new FXMLAvailableUsersBase(stage, usersResponseBean.getUsers()));
//                                }
//                            });
                        } else if (object.getString("operation").equals("requestPlaying")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    if (FXMLAvailableUsersBase.repeatedUserDialog != null) {
                                        FXMLAvailableUsersBase.repeatedUserDialog.closeLoadingDialog();
                                    }
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
                                    FXMLAvailableUsersBase.repeatedUserDialog.closeLoadingDialog();
                                    Stage stage = TicTacToeGame.getStage();
                                    Navigation.navigate(stage, new FXMLGameOnlineBase(stage, requestGameBean, true, requestGameBean.score));

                                }
                            });
                        } else if (object.getString("operation").equals("refuse")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    FXMLAvailableUsersBase.repeatedUserDialog.closeLoadingDialog();
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

                        } else if (object.getString("operation").equals("withdraw")) {
                            Stage stage = TicTacToeGame.getStage();

                            //dialogue to show him that the other player withdraw and navigate to online availbe users
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    //show dialog
//                                    Navigation.navigate(stage, new FXMLAvailableUsersBase(stage, users));
                                    System.out.println(".run() mafrod dialooggg");
                                    r.oppistePlayerWithDrawDialog("You are the winner! your friend withdraw");
                                    System.out.println(".run() mafrod dialooggg");
                                }
                            });
                        } else if (object.getString("operation").equals("logoutwithdraw")) {
                            Stage stage = TicTacToeGame.getStage();

                            //dialogue to show him that the other player withdraw and navigate to online availbe users
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    //show dialog
//                                    Navigation.navigate(stage, new FXMLAvailableUsersBase(stage, users));
                                    System.out.println(".run() mafrod dialooggg");
                                    r.oppistePlayerWithDrawDialog("You are the winner! your friend withdraw");
                                    System.out.println(".run() mafrod dialooggg");
                                }
                            });
                        }

//                        if (object.getString("operation").equals("serverStatus")) {
//
//                            System.out.println("operation from server= " + object.getString("close"));
//
//                        }
                    }
                } catch (SocketException ex) {

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }.start();
    }

    private ArrayList<UserOnline> removeMeFromList(ArrayList<UserOnline> users) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(userOnline.getUserName())) {
                users.remove(i);
            }
        }
        return users;
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
