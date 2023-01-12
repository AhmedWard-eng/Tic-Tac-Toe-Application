/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkOperations;

import DataBaseLayer.DataAccessLayer;
import beans.GameBean;
import beans.LoginBean;
import beans.LoginResponseBean;
import beans.LogoutBean;
import beans.RequestGameBean;
import beans.SignUpBean;
import beans.UserBean;
import beans.UsersResponseBean;
import com.google.gson.Gson;
import gameserver.ClientConnection;
import java.sql.SQLException;

import gameserver.Server;

/**
 *
 * @author AhmedWard
 */
public class NetworkOperation {

    DataAccessLayer dataAccessLayer;
    ClientConnection clientconnection;

    public NetworkOperation() {
        dataAccessLayer = new DataAccessLayer();
    }

    public boolean signUp(String message, String ip) throws SQLException {
        SignUpBean signuser = new Gson().fromJson(message, SignUpBean.class);

        UserBean user = new UserBean(ip, signuser.getUsername(), signuser.getPassword(), "offline", 0);
        System.out.println("user name before check data" + signuser.getUsername());
        boolean found = dataAccessLayer.checkIfUserExist(user.getUserName());
        System.out.println("found from Check=" + found);
        if (found) {
            return true;
        } else {
            dataAccessLayer.signUp(user);
            return false;
        }
    }

    public String login(LoginBean loginBean, String hostAddress) {
        return dataAccessLayer.login(loginBean, hostAddress);

    }

    public void logout(LogoutBean logoutBean, String hostAddress) {
        dataAccessLayer.logout(logoutBean, hostAddress);

    }

    public void requestPlay(String s, String ip) {

        System.out.println(s);
        RequestGameBean requestGameBean = new Gson().fromJson(s, RequestGameBean.class);
        if (requestGameBean.operation.equals("accept")) {
            System.out.println("aaa");
            dataAccessLayer.makePlayersBusy(requestGameBean.myIp,requestGameBean.otherPlayerIp);
        }
        for (int i = 0; i < Server.clientsVector.size(); i++) {
            if (Server.clientsVector.get(i).getIp().equals(requestGameBean.otherPlayerIp)) {
                Server.clientsVector.get(i).sendMessage(s);
            }

        }
    }
    
    
    public void sendGame(String s, String ip) {
        System.out.println(s);
        GameBean gameBean = new Gson().fromJson(s, GameBean.class);
        
        for (int i = 0; i < Server.clientsVector.size(); i++) {
            if (Server.clientsVector.get(i).getIp().equals(gameBean.ip)) {
                Server.clientsVector.get(i).sendMessage(s);
            }

        }
    }

    public String onlinePlayer() throws SQLException {
        System.out.println("onlinePlayer::::");
        UsersResponseBean userArray = new UsersResponseBean("onlineList", dataAccessLayer.getOnlinePlayers());

        String message = new Gson().toJson(userArray);
        return message;
    }
    
    public String retrievePlayerData(LoginResponseBean loginResponseBean) throws SQLException {
        System.out.println("onlinePlayer::::");
        UsersResponseBean userArray = new UsersResponseBean("onlineList", dataAccessLayer.getOnlinePlayers());
        
        loginResponseBean.setScore(dataAccessLayer.getPlayerScore(loginResponseBean.getUserName()));
        loginResponseBean.setUsers(userArray.getUsers());
        loginResponseBean.setMsg("login successfully");
        
        
        String message = new Gson().toJson(loginResponseBean);
        return message;
    }
    

}
