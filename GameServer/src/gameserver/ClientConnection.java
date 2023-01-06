/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameserver;

import DataBaseLayer.DataAccessLayer;
import beans.SignUpBean;
import beans.UserBean;
import com.google.gson.Gson;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.Socket;
import java.net.SocketAddress;
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
    NetworkOperation networkOperation;

    public ClientConnection(Socket socket) {
        this.socket = socket;
        networkOperation = new NetworkOperation();
        try {
            bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printStream = new PrintStream(socket.getOutputStream());
            signup();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void readMessages(){
        new Thread() {
            @Override
            public void run() {
                while (socket.isConnected()) {

                    System.out.println("readMessage is running.......");
                    try {
                        String s = bufferReader.readLine();
                        s = s.replaceAll("\r?\n", "");
                        JsonReader jsonReader = (JsonReader) Json.createReader(new StringReader(s));
                        JsonObject object = jsonReader.readObject();
//                        System.out.println("b3d");
                        if (object.getValueType() == JsonStructure.ValueType.OBJECT) {
                            System.out.println("status = " + object.getString("status"));
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }

        }.start();
    }

    public void signup() {
        new Thread() {
            @Override
            public void run() {
                while (!socket.isClosed()) {

                    System.out.println("readMessage is running......."+socket.isClosed());
                    try {
                        String s = bufferReader.readLine();
                        s = s.replaceAll("\r?\n", "");
                        System.out.println(s);
                        JsonReader jsonReader = (JsonReader) Json.createReader(new StringReader(s));
                        JsonObject object = jsonReader.readObject();
                        if (object.getValueType() == JsonStructure.ValueType.OBJECT) {
                            System.out.println("status = " + object.getString("password"));
                        }
                       networkOperation.signUp(new Gson().fromJson(s, SignUpBean.class),socket.getInetAddress().getHostAddress());
                    } catch (IOException ex) {
//                        ex.printStackTrace();
                    }
                }
            }

        }.start();
    }
    

             

}
