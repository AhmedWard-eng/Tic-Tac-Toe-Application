/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import beans.UserOnline;
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
import javafx.scene.control.TextArea;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author AhmedWard
 */
public class NetworkConnection {

    Socket socket;
    BufferedReader bufferedReader;
    PrintStream ps;
    public static ArrayList<UserOnline> list;
    public static ArrayList<String> listPlayer;

    public NetworkConnection() {
        try {

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
                        //   String json_string = str.replaceAll("\r?\n", "");
                        //   System.out.println("AttaySjson_stringteeeeeeeeeeeeeeesssst" + json_string);

                        // listPlayer=new ArrayList<>();
                        //       listPlayer.add(str);
                        //          System.out.println("ListPlayerrrrrrr:::::ioj"+listPlayer.get(0).toString());
                        //             System.out.println("AttayString..." + listPlayer.get(0));
//                        Gson g = new Gson();
//                        UserOnline p = g.fromJson(str, UserOnline.class);
//                        list = new ArrayList<>();
//                        //  while(p.getStatus().equals("online")){
//                        if (p.getStatus().equals("online")) {
//
//                            list.add(p);
//                            System.out.println("done.." + p.getUserName());
//                            System.out.println("CCCCCCCCLLIInt" + list.toString());
//
//                        }
//                         System.out.println();
//                         
//                        } else {
//                            System.out.println("string without jesson....!!!");
//                        }
                        // System.out.println("client recived...= " + str);
                        //object.getString("operation").equals("login")
                        //onlinList
                        
//                        JsonReader jsonReader = (JsonReader) Json.createReader(new StringReader(str));
//                        JsonObject object = jsonReader.readObject();
                       
                            list = new ArrayList<>();
                            JsonParser jsonParser = new JsonParser();
                            JsonArray jsonArray = (JsonArray) jsonParser.parse(str);
                            for (int i = 0; i < jsonArray.size(); i++) {
                                UserOnline p = new Gson().fromJson(jsonArray.get(i).toString(), UserOnline.class);
                                list.add(p);
                                System.out.println("done.." + p.getUserName());
                                System.out.println("CCCCCCCCLLIInt" + list.toString());
                            }
                      
                        if (str.equals("Exist username")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    r.ExistDialog();
                                }
                            });

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
