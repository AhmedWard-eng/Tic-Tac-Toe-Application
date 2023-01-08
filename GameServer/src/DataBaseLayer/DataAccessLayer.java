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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public void login(LoginBean loginBean, String Ip) {
        System.out.println("username bean = " + loginBean.getUsername());
        System.out.println("password bean = " + loginBean.getPassword());
        //put login logic
        try {
            PreparedStatement pst = connection.prepareStatement("Select root.\"game\".\"password\" FROM root.\"game\" where root.\"game\".\"username\" = ?");
            pst.setString(1, loginBean.getUsername().toString());
            ResultSet rs = pst.executeQuery();

            //only if the username is unique
            if (rs.next()) {

                if (rs.getString(1).equals(loginBean.getPassword())) {
                    pst = connection.prepareStatement("update root.\"game\" set root.\"game\".\"status\" = 'online' where root.\"game\".\"username\" = ?");
                    pst.setString(1, "hossam");
                    pst.executeUpdate();
                    System.out.println("login successfully");
                } else {
                    System.out.println("invalid data! please try to login again..");
                }
            } else {
                System.out.println("this username is not reistered");
            }

            pst.close();
            connection.close();
            //TODO handle no user found
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void signUp(UserBean userBean) {
        //put login logic
    }

    public boolean checkvalidSignUp() {
        return true;
    }

//    public ArrayList<UserBean> getOnlineAndBusyUsers(){
//    
//    
//    }
}
