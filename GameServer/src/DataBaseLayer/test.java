/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseLayer;

//import java.sql.SQLException;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Nada Hamed
 */
public class test {
    public static void main(String[] args) {
        try {
            DataAccessLayer test= new DataAccessLayer();
            int x=test.getOnlineRate();
            System.out.println("online players num= "+ x);
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
