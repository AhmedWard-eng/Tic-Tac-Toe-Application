/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseLayer;

import beans.LoginBean;
import beans.UserBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;

/**
 *
 * @author AhmedWard
 */
public class DataAccessLayer {
    

    private Connection connection;

    public DataAccessLayer() {
        try {
            DriverManager.registerDriver(new ClientDriver());
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/game", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void login(LoginBean loginBean,String Ip){
        //put login logic
    }
    
    
    public void signUp(UserBean userBean) {
        //put login logic
    }
    
    public boolean checkvalidSignUp(){
        return true;
    }
    
//    public ArrayList<UserBean> getOnlineAndBusyUsers(){
//    
//    
//    }
    
    
    
}
