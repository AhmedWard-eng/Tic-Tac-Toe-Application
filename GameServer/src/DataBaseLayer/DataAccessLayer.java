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

    public void signUp(UserBean userBean) throws SQLException {

        String sqlinsert = "INSERT INTO ROOT.\"game\"(ROOT.\"game\".\"ip\",ROOT.\"game\".\"username\",ROOT.\"game\".\"password\",ROOT.\"game\".\"status\")VALUES (?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(sqlinsert);
        pst.setString(1, userBean.getIp());
        pst.setString(2, userBean.getUserName());
        pst.setString(3, userBean.getPass());
        pst.setString(4, userBean.getStatus());
        int rs = pst.executeUpdate();
        if (rs == 0) {
            System.out.println("0");
        } else {
            System.out.println("1");
        }
    }

    public boolean checkIfUserExist(String userName) throws SQLException {
        String sql = " SELECT ROOT.\"game\".\"username\" FROM  ROOT.\"game\" Where ROOT.\"game\".\"username\"=? ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, userName);
        ResultSet rs = pst.executeQuery();
        boolean found = false;
        if (rs != null) {
            found = true;
        }
        return found;
    }

}
