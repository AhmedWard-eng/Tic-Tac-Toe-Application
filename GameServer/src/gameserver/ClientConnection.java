/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameserver;

import DataBaseLayer.DataAccessLayer;
import beans.LoginBean;
import beans.LoginResponseBean;
import beans.LogoutBean;
import beans.SignUpBean;
import beans.UserBean;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import com.google.gson.GsonBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.rmi.ServerException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.stage.Stage;
import javax.json.Json;
import javax.json.JsonStructure;
import networkOperations.NetworkOperation;

/**
 *
 * @author AhmedWard
 */
public class ClientConnection {

    Socket socket;
    BufferedReader bufferReader;
    PrintStream printStream;
    String ip;
    int portNum;
    NetworkOperation networkOperation;

    public ClientConnection(Socket socket) {
        this.socket = socket;
        ip = socket.getInetAddress().getHostAddress();
        portNum = socket.getPort();
        networkOperation = new NetworkOperation();
        try {
            bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printStream = new PrintStream(socket.getOutputStream());
            readMessages();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getIp() {
        return ip;
    }

    public void readMessages() {
        new Thread() {
            @Override
            public void run() {

                while (!socket.isClosed() && socket.isConnected()) {

//                    System.out.println("readMessage is running......." + "::  " + ip + "--" + portNum);
                    try {

                        String message = bufferReader.readLine();
//                        System.out.println(message);
                        if (message == null) {

                            Server.clientsVector.remove(ClientConnection.this);
                            continue;
                        }
                        message = message.replaceAll("\r?\n", "");
                        JsonReader jsonReader = (JsonReader) Json.createReader(new StringReader(message));
                        JsonObject object = jsonReader.readObject();

                        //System.out.println(object.getString("operation"));
                        //System.out.println("operationnnnnnnn" + object.getString("operation"));
                        if (object.getString("operation").equals("signup")) {
                            boolean exist = networkOperation.signUp(message, ip);
                            System.out.println("clint exist= " + exist);
                            String found;
                            if (!exist) {
                                found = "notExist";
                            } else {
                                found = "exist";
                            }
                            Map<String, String> map = new HashMap<>();
                            map.put("operation", "signup");
                            map.put("message", found);

                            message = new Gson().toJson(map);
                            sendMessage(message);

                        } else if (object.getString("operation").equals("login")) {
                            //TODO update ip in the database

                            LoginBean loginBean = new LoginBean(null, object.getString("username"), object.getString("password"));
                            String loginResponse = networkOperation.login(loginBean, ip);
                            System.out.println(loginResponse);

                            Map<String, String> map = new HashMap<>();
                            map.put("operation", "loginResponse");
                            map.put("msg", loginResponse);
                            message = new GsonBuilder().create().toJson(map);
                            if (loginResponse.equals("login successfully")) {

                                LoginResponseBean loginResponseBean = new LoginResponseBean("loginResponse", object.getString("username"), 0, null, null);
                                String resMessage = networkOperation.retrievePlayerData(loginResponseBean);

                                sendMessage(resMessage);

                            } else {
                                sendMessage(message);
                            }

                            System.out.println("ipppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp" + ip);

                        } else if (object.getString("operation").equals("logout")) {
                            //TODO update ip in the database
                            LogoutBean logoutBean = new LogoutBean("logout", object.getString("username"));
                            networkOperation.logout(logoutBean, ip);

                        } else if (object.getString("operation").equals("requestPlaying")) {
                            System.out.println(message);
                            networkOperation.requestPlay(message, ip, ClientConnection.this);
                        } else if (object.getString("operation").equals("accept")) {
                            System.out.println(message);
                            networkOperation.requestPlay(message, ip, ClientConnection.this);
                        } else if (object.getString("operation").equals("refuse")) {
                            System.out.println(message);
                            networkOperation.requestPlay(message, ip, ClientConnection.this);
                        } else if (object.getString("operation").equals("gameMove")) {
                            System.out.println(message);
                            networkOperation.sendGame(message, ip, ClientConnection.this);

                        } else if (object.getString("operation").equals("gameFinish")) {
                            System.out.println(message);
                            networkOperation.gameFinish(message, ip);
                        } else if (object.getString("operation").equals("reloadUsersList")) {
                            String players = networkOperation.onlinePlayer();
                            //message = new Gson().toJson(players);
                            System.out.println("a7a");
                            sendMessage(players);
                        }

                    } catch (SocketException ex) {
                        Server.clientsVector.remove(ClientConnection.this);

                    } catch (IOException ex) {
                        ex.printStackTrace();

                    } catch (SQLException ex) {
                        Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();
    }

    public void sendMessage(String message) {
        new Thread() {
            @Override
            public void run() {
                printStream.println(message);
            }

        }.start();
    }

}
