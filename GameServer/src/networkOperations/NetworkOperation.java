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

//    public void signUp(UserBean user) throws SQLException {
//        // UserBean userBean = new UserBean(hostAddress, signUpBean.getUsername(), signUpBean.getPassword(), "Online", 0);
//        dataAccessLayer.signUp(user);
//    }

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
}
