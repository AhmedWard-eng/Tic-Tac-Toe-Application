/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

/**
 *
 * @author AhmedWard
 */
public class Record {

    public String player1;
    public String player2;
    public ArrayList<Cell> board;

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public ArrayList<Cell> getBoard() {
        return board;
    }

    public Record(String player1, String player2) {
        board = new ArrayList<>();
        this.player1 = player1;
        this.player2 = player2;
    }
}
