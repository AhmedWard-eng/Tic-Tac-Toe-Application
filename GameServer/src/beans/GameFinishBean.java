/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author AhmedWard
 */
public class GameFinishBean {
    public String operation;
    public GameStatus gameStatus;
    public String userName;

    public GameFinishBean(String operation, GameStatus gameStatus, String userName) {
        this.operation = operation;
        this.gameStatus = gameStatus;
        this.userName = userName;
    }

    
    
}
