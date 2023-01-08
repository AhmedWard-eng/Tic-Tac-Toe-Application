/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkOperations;

import DataBaseLayer.DataAccessLayer;
import beans.SignUpBean;
import beans.UserBean;
import gameserver.Server;

/**
 *
 * @author AhmedWard
 */
public class NetworkOperation {

    DataAccessLayer dataAccessLayer;

    public NetworkOperation() {

       // dataAccessLayer = new DataAccessLayer();
    }

    public void signUp(SignUpBean signUpBean, String hostAddress) {
        UserBean userBean = new UserBean(hostAddress, signUpBean.getUsername(), signUpBean.getPassword(), "Online", 0);
        dataAccessLayer.signUp(userBean);
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

}
