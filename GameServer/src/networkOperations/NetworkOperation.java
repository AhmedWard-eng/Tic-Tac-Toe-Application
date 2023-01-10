/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkOperations;

import DataBaseLayer.DataAccessLayer;
import beans.LoginBean;
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

    public boolean signUp(String message,String ip) throws SQLException {
        SignUpBean signuser = new Gson().fromJson(message, SignUpBean.class);
        UserBean user = new UserBean(ip, signuser.getUsername(), signuser.getPassword(), "online", 0);
        boolean found=dataAccessLayer.checkIfUserExist(user.getUserName());
        System.out.println("found from Check="+found);
        if(found){
            return true;       
        }
        else{
            dataAccessLayer.signUp(user);
            return false;
        }
    }


    public void login(LoginBean loginBean, String hostAddress) {
        dataAccessLayer.login(loginBean, hostAddress);
    }

    public void requestPlay(String s,String ip) {
        //parse string 
        //get ip of the second player
        //send request to the second palyer
        for(int i = 0;  i < Server.clientsVector.size(); i++ ){
            if(Server.clientsVector.get(i).getIp() == ip){
                Server.clientsVector.get(i).sendMessage("message");
            }
        }
    }
    
    public com.google.gson.JsonArray onlinePlayer() throws SQLException {
        //  dataAccessLayer.getOnlinePlayers();
        System.out.println("onlinePlayer::::");
        return dataAccessLayer.getOnlinePlayers();
    }


}
