/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkOperations;

import DataBaseLayer.DataAccessLayer;
import beans.LoginBean;
import beans.LogoutBean;
import beans.RequestGameBean;
import beans.SignUpBean;
import beans.UserBean;
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
        UserBean user = new UserBean(ip, signuser.getUsername(), signuser.getPassword(), "online", 0);
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

        RequestGameBean requestGameBean = new Gson().fromJson(s, RequestGameBean.class);
        for (int i = 0; i < Server.clientsVector.size(); i++) {
            if (Server.clientsVector.get(i).getIp().equals(requestGameBean.otherPlayerIp)) {
                System.out.println(Server.clientsVector.get(i).getIp());
                System.out.println(requestGameBean.otherPlayerIp);
                Server.clientsVector.get(i).sendMessage("message");
            }

            System.out.println(Server.clientsVector.get(i).getIp());
            System.out.println(requestGameBean.otherPlayerIp);
            System.out.println(Server.clientsVector.get(i).getIp().equals(requestGameBean.otherPlayerIp));
        }
    }
    

}
