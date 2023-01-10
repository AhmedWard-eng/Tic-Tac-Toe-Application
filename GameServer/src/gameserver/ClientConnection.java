/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameserver;

import DataBaseLayer.DataAccessLayer;
import beans.LoginBean;
import beans.SignUpBean;
import beans.UserBean;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

            System.out.println("........");
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
                while (socket.isConnected()) {

                    System.out.println("readMessage is running......." + "::  " + ip + "--" + portNum);
                    try {
                        
                        String message = bufferReader.readLine();
                        message = message.replaceAll("\r?\n", "");
                        JsonReader jsonReader = (JsonReader) Json.createReader(new StringReader(message));
                        JsonObject object = jsonReader.readObject();

                        if (object.getString("operation").equals("signup")) {
                            boolean exist = networkOperation.signUp(message, ip);
                            System.out.println("clint exist= " + exist);
                            // sendMessage("Exist ");
                            // System.out.println("exist???????"+exist);
                            exist = false;
                            if (exist) {
                                //  sendMessage("Exist username");
                            } else {
                                //////*****/////****//--Online--//****//////****////****             
                                System.out.println("Marinaaaaaaaaaaaa");
                                try {
                                    JsonArray jesonOnlineList = networkOperation.onlinePlayer();
                                    for (int i = 0; i < jesonOnlineList.size(); i++) {
                                        System.out.println("String jeson online: " + jesonOnlineList.get(i)+"Size = "+jesonOnlineList.size());
                                        String jsonString = jesonOnlineList.get(i).toString();
                                        sendMessage(jsonString);
                                        System.out.println("send message" + jsonString);
                                    }
                                    System.out.println("online::==>" + networkOperation.onlinePlayer());
                                } catch (SQLException ex) {
                                    Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                     ///////////*********//////////*************/////////////****//
                     
                        } else if (object.getString("operation").equals("login")) {
                            //TODO update ip + status in the database
                            LoginBean loginBean = new LoginBean(null, object.getString("username"), object.getString("password"));
                            networkOperation.login(loginBean, ip);
                        } else if (object.getString("status") == "requestPlaying") {
                            networkOperation.requestPlay(message, ip);
                        }

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
