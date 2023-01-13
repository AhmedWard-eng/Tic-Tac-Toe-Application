/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import javafx.scene.control.Label;

/**
 *
 * @author AhmedWard
 */
public class Record {
    
    public String player1;
    public String player2;
    public ArrayList<Cell> board;
    public Cell borderLabel[][];

    public Record(Label[][] borderLabel, String you, String computer) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getPlayer1() {
        return player1;
}

    public String getPlayer2() {
        return player2;
    }

    public ArrayList<Cell> getBoard() {
        return board;
    }

    public Record(ArrayList<Cell> board,String player1, String player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }
}
