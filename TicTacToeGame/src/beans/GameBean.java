/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import game.Cell;

/**
 *
 * @author AhmedWard
 */
public class GameBean {
    public String operation;
    public String ip;
    public Cell cell;

    public GameBean(String operation,String ip ,Cell cell) {
        this.operation = operation;
        this.cell = cell;
        this.ip = ip;
    }

    public GameBean() {
    }
    
}
