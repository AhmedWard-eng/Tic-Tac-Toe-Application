/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author AhmedWard
 */
public class GameInfo {

    public String date;
    public String playerOne;
    public String playetTwo;

    public GameInfo(String fileName) {

        String[] fileNameSplitter = fileName.split("##");
        
        this.date =fileNameSplitter[0].replace("--", ":");
        this.playerOne = fileNameSplitter[1];
        this.playetTwo = fileNameSplitter[2].split("\\.")[0];
    }

}
