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
    private static DataAccessLayer dao;

    public static DataAccessLayer getInstance() {
        if (dao == null) {

            dao = new DataAccessLayer();
        }
        return dao;
    }

    private DataAccessLayer() {
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

                    System.out.println("login bean" + loginBean);

                    pst = connection.prepareStatement("update root.\"game\" set root.\"game\".\"ip\" = ? where root.\"game\".\"username\" = ?");
                    pst.setString(1, Ip);
                    pst.setString(2, loginBean.getUsername());
                    pst.executeUpdate();

                    updateIp(Ip, loginBean.getUsername());
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

    public boolean makePlayersBusy(String ip1, String ip2) {
        try {
            String sqlUpdate = "Update ROOT.\"game\" set ROOT.\"game\".\"status\" = ? where ROOT.\"game\".\"ip\" = ? or ROOT.\"game\".\"ip\" = ?";
            PreparedStatement pst = connection.prepareStatement(sqlUpdate);
            pst.setString(1, "busy");
            pst.setString(2, ip1);
            pst.setString(3, ip2);
            int rs = pst.executeUpdate();
            System.out.println("rs = " + rs);
            return rs != 0;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return false;
        }
    }

    private void updateIp(String Ip, String userName) throws SQLException {
        String sqlUpdate = "Update ROOT.\"game\" set ROOT.\"game\".\"ip\" = ? where ROOT.\"game\".\"username\" = ?";
        PreparedStatement pst = connection.prepareStatement(sqlUpdate);
        pst.setString(1, Ip);
        pst.setString(2, userName);
        int rs = pst.executeUpdate();
    }

    public int getPlayerScore(String userName) throws SQLException {

        String sql = " SELECT * FROM  ROOT.\"game\" Where ROOT.\"game\".\"username\"=? ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, userName);
        ResultSet resultSet = pst.executeQuery();
        Gson gson = new GsonBuilder().create();
        if (resultSet.next()) {
            return resultSet.getInt("score");
        } else {
            return 0;
        }
    }

    public boolean updateScore(String userName, int score) {
        try {
            String sqlUpdate = "Update ROOT.\"game\" set ROOT.\"game\".\"SCORE\" = ? where ROOT.\"game\".\"username\" = ?";
            PreparedStatement pst = connection.prepareStatement(sqlUpdate);
            pst.setInt(1, score);
            pst.setString(2, userName);
            int rs = pst.executeUpdate();
            System.out.println("rs = " + rs);
            return rs != 0;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return false;
        }
    }

    public boolean makeuserOnline(String ip) {
        try {
            String sqlUpdate = "Update ROOT.\"game\" set ROOT.\"game\".\"status\" = ? where ROOT.\"game\".\"ip\" = ?";
            PreparedStatement pst = connection.prepareStatement(sqlUpdate);
            pst.setString(1, "online");
            pst.setString(2, ip);
            int rs = pst.executeUpdate();
            System.out.println("rs = " + rs);
            return rs != 0;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return false;
        }

    }

    public boolean makeuserOffline(String ip) {
        try {
            String sqlUpdate = "Update ROOT.\"game\" set ROOT.\"game\".\"status\" = ? where ROOT.\"game\".\"ip\" = ?";
            PreparedStatement pst = connection.prepareStatement(sqlUpdate);
            pst.setString(1, "offline");
            pst.setString(2, ip);
            int rs = pst.executeUpdate();
            System.out.println("rs = " + rs);
            return rs != 0;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return false;
        }

    }

}
