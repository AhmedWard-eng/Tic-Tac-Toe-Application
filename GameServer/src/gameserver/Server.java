/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameserver;

import DataBaseLayer.DataAccessLayer;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AhmedWard
 */
public class Server {

    ServerSocket serverSocket;
    //ClientConnection clientConnection;
    boolean isOpened;

    public static Vector<ClientConnection> clientsVector = new Vector<ClientConnection>();

    public Server() {

        try {
            serverSocket = new ServerSocket(5005);
            isOpened = true;
            acceptNewClient();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeConnection() throws IOException {
        isOpened = false;
        DataAccessLayer dao = new DataAccessLayer();
//        if (clientConnection != null) {

//        System.out.println("Close Connection is Called ");
        for (int i = 0; i < clientsVector.size(); i++) {

            Socket socket = clientsVector.get(i).socket;

            Map<String, String> map = new HashMap<>();
            map.put("operation", "serverStatus");
            map.put("message", "close");

            String message = new Gson().toJson(map);

            clientsVector.get(i).sendMessage(message);
//            System.out.println();
            dao.makeuserOffline(clientsVector.get(i).getIp());
            socket.close();

            System.err.println(" socket isclosed " + socket.isClosed());
            System.err.println(" socket isConnected " + socket.isConnected());
        }

        serverSocket.close();
        try {
            dao.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

        clientsVector.clear();
    }

    private void acceptNewClient() {
        new Thread() {
            @Override
            public void run() {

                while (!serverSocket.isClosed()) {
                    try {
                        Socket socket = serverSocket.accept();
                        clientsVector.add(new ClientConnection(socket));
                        System.out.println("server number of clients" + clientsVector.size());

                        System.out.println("Accept new Client is running.......");
                    } catch (SocketException ex) {
                        System.out.println("socket is closed");

                    } catch (IOException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        }.start();
    }

}
