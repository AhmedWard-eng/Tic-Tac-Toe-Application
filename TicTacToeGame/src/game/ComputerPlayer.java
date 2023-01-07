/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Random;
import javafx.application.Platform;
import javafx.scene.Scene;
import tictactoegame.FXMLGameOnePlayerEasyBase;
import tictactoegame.FXMLResultLoseBase;

/**
 *
 * @author AhmedWard
 */
public class ComputerPlayer {

    GameManager gameManager;
    int compStep;

    public ComputerPlayer(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public int getComputerChoice() {
        compStep = new Random().nextInt(9);

        while (gameManager.getCell(compStep).content != Seed.NO_SEED) {
            compStep = new Random().nextInt(9);
        }

        return compStep;
    }
}
