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
public class GameManager {

    public static final int TOTAL_NUM_CELLS = 9;
    private ArrayList<Cell> recordedGame;
    private ArrayList<Cell> board;
    boolean isRecorded;
    int counterGames;

    public GameManager() {
        init();
    }

    private void init() {
        recordedGame = new ArrayList<>();
        board = new ArrayList<>();
        counterGames = 0;
        for (int i = 0; i < TOTAL_NUM_CELLS; i++) {
            board.add(new Cell());
        }
    }

    public void newGame() {
        isRecorded = false;
        counterGames = 0;
        for (int i = 0; i < TOTAL_NUM_CELLS; i++) {
            board.get(i).content = Seed.NO_SEED;
        }
    }

    public void setCell(int index, Seed seed) {
        if (isRecorded) {
            recordedGame.add(new Cell(seed, index));
        }
        board.get(index).content = seed;
        counterGames++;

        System.out.println(counterGames + " in set Cell");

    }

    public Cell getCell(int index) {
        return board.get(index);
    }

    public void setRecorded(boolean isRecorded) {
        this.isRecorded = isRecorded;
    }

    public boolean isPlayerXWon() {
        return checkColWin(Seed.CROSS) || checkRowWin(Seed.CROSS) || ckeckDiagonalWin(Seed.CROSS);
    }

    public boolean isPlayerOWon() {
        return checkColWin(Seed.NOUGHT) || checkRowWin(Seed.NOUGHT) || ckeckDiagonalWin(Seed.NOUGHT);
    }

    public boolean isDraw() {
        if (counterGames == 9 && !isPlayerOWon() && !isPlayerXWon()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkRowWin(Seed seed) {
        if (board.get(0).content == board.get(1).content && board.get(0).content == board.get(2).content && board.get(0).content == seed) {
            return true;
        } else if (board.get(3).content == board.get(4).content && board.get(3).content == board.get(5).content && board.get(3).content == seed) {
            return true;
        } else if (board.get(6).content == board.get(7).content && board.get(6).content == board.get(8).content && board.get(6).content == seed) {
            return true;
        }
        return false;
    }

    private boolean checkColWin(Seed seed) {
        if (board.get(0).content == board.get(3).content && board.get(0).content == board.get(6).content && board.get(0).content == seed) {
            return true;
        } else if (board.get(1).content == board.get(4).content && board.get(1).content == board.get(7).content && board.get(1).content == seed) {
            return true;
        } else if (board.get(2).content == board.get(5).content && board.get(2).content == board.get(8).content && board.get(2).content == seed) {
            return true;
        }
        return false;
    }

    private boolean ckeckDiagonalWin(Seed seed) {
        if (board.get(0).content == board.get(4).content && board.get(0).content == board.get(8).content && board.get(0).content == seed) {
            return true;
        } else if (board.get(2).content == board.get(4).content && board.get(2).content == board.get(6).content && board.get(2).content == seed) {
            return true;
        }
        return false;
    }

    public void saveRecord() {
        if (isRecorded) {
            System.out.println("save Record");
        }
    }

    public void print() {
        for (int i = 0; i < board.size(); i++) {
            System.out.println(board.get(i).content.getIcon());
        }
        System.out.println("----------------------------------------");
    }

}
