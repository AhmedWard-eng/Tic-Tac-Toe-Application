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
    NetworkOperation networkOperation;

    public ClientConnection(Socket socket) {
        this.socket = socket;
        ip = socket.getInetAddress().getHostAddress();
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

    public void readMessages() {
        new Thread() {
            @Override
            public void run() {
                while (socket.isConnected()) {

                    System.out.println("readMessage is running.......");
                    try {

                        String message = bufferReader.readLine();
                        message = message.replaceAll("\r?\n", "");
                        JsonReader jsonReader = (JsonReader) Json.createReader(new StringReader(message));
                        JsonObject object = jsonReader.readObject();
                        if (object.getString("operation").equals("signup")) {
                            boolean exist = networkOperation.signUp(message, ip);
                            System.out.println("clint exist= " + exist);
                            sendMessage("Exist ");
                            if (exist) {
                                sendMessage("Exist username");
                            }
                        }
                        if (object.getString("status").equals("login")) {
                            //TODO update ip + status in the database
                            LoginBean loginBean = new LoginBean(null, object.getString("username"), object.getString("password"));
                            networkOperation.login(loginBean, "1123.456.789");
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

    private void sendMessage(String message) {
        new Thread() {
            @Override
            public void run() {
                printStream.println(message);
            }

        }.start();
    }

}
