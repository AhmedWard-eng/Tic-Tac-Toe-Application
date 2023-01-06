/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameserver;

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

/**
 *
 * @author AhmedWard
 */
public class ClientConnection {

    Socket socket;
    BufferedReader bufferReader;
    PrintStream printStream;
    String ip;

    public ClientConnection(Socket socket) {
        this.socket = socket;
        try {
            bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printStream = new PrintStream(socket.getOutputStream());
            readMessages();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void readMessages() {
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

}
