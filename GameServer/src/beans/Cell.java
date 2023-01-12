/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;

/**
 *
 * @author AhmedWard
 */
public class Cell {

    public Seed content;
    public int index;

    public Cell() {
        content = Seed.NO_SEED;
    }

    public Cell(Seed seed, int index) {
        this.content = seed;
        this.index = index;
    }

}
