/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseLayer;

import beans.LoginBean;
import beans.LogoutBean;
import beans.UserBean;
import beans.UserOnline;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
 * @author Ward Fadaly Marina Nada
 */
public class DataAccessLayer {

    private Connection connection;
    PreparedStatement pst;

    public DataAccessLayer() {
        try {
            DriverManager.registerDriver(new ClientDriver());
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/game", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String login(LoginBean loginBean, String Ip) {
        //put login logic
        try {
            PreparedStatement pst = connection.prepareStatement("Select root.\"game\".\"password\" FROM root.\"game\" where root.\"game\".\"username\" = ?");
            pst.setString(1, loginBean.getUsername().toString());
            ResultSet rs = pst.executeQuery();

            //only if the username is unique
            if (rs.next()) {

                if (rs.getString(1).equals(loginBean.getPassword())) {
                    pst = connection.prepareStatement("update root.\"game\" set root.\"game\".\"status\" = 'online' where root.\"game\".\"username\" = ?");
                    pst.setString(1, loginBean.getUsername());
                    pst.executeUpdate();

                    return "login successfully";
                } else {
                    return "Invalid data! please try to login again..";
                }
            } else {
                return "This username is not reistered";
            }

            //TODO handle no user found
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
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
            System.out.println("insert faild");
        } else {
            System.out.println("insert succeded");
        }
    }

    public boolean checkIfUserExist(String userName) throws SQLException {
        String sql = " SELECT ROOT.\"game\".\"username\" FROM  ROOT.\"game\" Where ROOT.\"game\".\"username\"=? ";

        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, userName);
        ResultSet rs = pst.executeQuery();
        boolean found = false;

        while (rs.next()) {
            if (userName.equals(rs.getString("username"))) {
                System.out.println("the user exist olready");
                found = true;
                return found;
            }
        }
        return found;
    }
    public ArrayList<UserOnline> getOnlinePlayers() throws SQLException {

        ArrayList<UserOnline> onlinePlayers = new ArrayList<>();

        String sql = " SELECT * FROM  ROOT.\"game\" Where ROOT.\"game\".\"status\"='online' ";
        PreparedStatement pst = connection.prepareStatement(sql);

        ResultSet resultSet = pst.executeQuery();
        Gson gson = new GsonBuilder().create();
        while (resultSet.next()) {
            onlinePlayers.add(new UserOnline(
                    resultSet.getString("ip"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("status"),
                    resultSet.getInt("score") 
                    ));
        }

        return onlinePlayers;

    }
    
    public double getOnlineRate() throws SQLException {
        String sql = "select count( ROOT.\"game\".\"id\") AS total FROM  ROOT.\"game\" Where ROOT.\"game\".\"status\"=? ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, "online");
        int count = 0;
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            count = rs.getInt("total");
        }
        return count;
    }
    
    public double getbusyeRate() throws SQLException {
        String sql = "select count( ROOT.\"game\".\"id\") AS total FROM  ROOT.\"game\" Where ROOT.\"game\".\"status\"=? ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, "busy");
        int count = 0;
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            count = rs.getInt("total");
        }
        return count;
    }

    
    public double getOfflineRate() throws SQLException {

        String sql = "select count( ROOT.\"game\".\"id\") AS total FROM  ROOT.\"game\" Where ROOT.\"game\".\"status\"=? ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, "offline");
        int count = 0;
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            count = rs.getInt("total");
        }
        return count;
    }

        public void logout(LogoutBean logoutBean, String Ip) {
        try {

            System.out.println("DataBaseLayer.DataAccessLayer.logout()  " + logoutBean.getOperation());
            System.out.println("DataBaseLayer.DataAccessLayer.logout()  " + logoutBean.getUsername());
            
            
            pst = connection.prepareStatement("update root.\"game\" set root.\"game\".\"status\" = 'offline' where root.\"game\".\"username\" = ?");
            pst.setString(1, logoutBean.getUsername());
            
            System.out.println("DataBaseLayer.DataAccessLayer.logout()  " + logoutBean.getOperation());
            System.out.println("DataBaseLayer.DataAccessLayer.logout()  " + logoutBean.getUsername());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
