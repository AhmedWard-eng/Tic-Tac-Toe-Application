/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import javafx.scene.control.TextArea;

/**
 *
 * @author AhmedWard
 */
public class NetworkConnection {

    Socket socket;
    BufferedReader bufferedReader;
    PrintStream ps;

    public NetworkConnection() {
        try {
            socket = new Socket(InetAddress.getLocalHost(), 5005);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ps = new PrintStream(socket.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void readMessage() {

        new Thread() {
            @Override
            public void run() {
                try {
                    while (socket.isClosed()) {
                        System.out.print(bufferedReader.readLine());
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
