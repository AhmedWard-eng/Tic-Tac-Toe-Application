/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseLayer;

import beans.LoginBean;
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
                    pst.setString(1, "hossam");
                    pst.executeUpdate();
                    connection.close();
                    pst.close();
                    return "login successfully";
                } else {
                    return "invalid data! please try to login again..";
                }
            } else {
                return "this username is not reistered";
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
        PreparedStatement pst = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
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

//            System.out.println("in wile" + onlinePlayers.get(0) + "ResultStatment" + resultSet);
//            username = resultSet.getString("username");
//            status = resultSet.getString("status");
        }
//        com.google.gson.JsonArray array = gson.toJsonTree(onlinePlayers).getAsJsonArray();
//        System.out.println("jeson online " + gson.toJsonTree(onlinePlayers).getAsJsonArray());
//        System.out.println("****array jeson***" + array);
//        System.out.println("online: ArrayList" + onlinePlayers.get(0) + "\n userName" + username + "\nstatus" + status);
        // return onlinePlayers;
        return onlinePlayers;

    }


    public int getOnlineRate() throws SQLException {
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

    public int getOfflineRate() throws SQLException {
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

}
