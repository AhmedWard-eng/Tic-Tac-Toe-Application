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
public enum Seed {
    CROSS("X"), NOUGHT("O"), NO_SEED(" ");
    
    
    
    private final String icon;

    private Seed(String content) {
        this.icon = content;
    }

    public String getIcon() {
        return icon;
    }

}


