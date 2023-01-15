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
        DataAccessLayer test = new DataAccessLayer();
//            double x = test.getOnlineRate();
//            double y = test.getOfflineRate();
//            System.out.println("online players num= "+ x);
//            System.out.println("offline players num= "+ y);
//            int score = test.getPlayerScore("ward");
//            System.out.println(score);
//            test.updateScore("ward",score+5);

//        test.makeuserOnline("192.168.1.2");
//            Thread.sleep(1000);
        test.makeuserOffline("192.168.1.2");

    }

}
