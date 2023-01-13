/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import beans.GameFinishBean;
import beans.GameStatus;
import com.google.gson.Gson;

/**
 *
 * @author AhmedWard
 */
public class test {

    public static void main(String[] args) {
        System.out.println(new Gson().toJson(new GameFinishBean("gameFinish", GameStatus.DRAW, "ward")));
    }
}
