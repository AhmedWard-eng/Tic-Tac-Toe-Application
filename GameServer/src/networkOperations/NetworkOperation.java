/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkOperations;

import DataBaseLayer.DataAccessLayer;
import beans.SignUpBean;
import beans.UserBean;
import com.google.gson.Gson;
import java.sql.SQLException;

/**
 *
 * @author AhmedWard
 */
public class NetworkOperation {

    DataAccessLayer dataAccessLayer;

    public NetworkOperation() {

        dataAccessLayer = new DataAccessLayer();
    }

//    public void signUp(UserBean user) throws SQLException {
//        // UserBean userBean = new UserBean(hostAddress, signUpBean.getUsername(), signUpBean.getPassword(), "Online", 0);
//        dataAccessLayer.signUp(user);
//    }

    public void signUp(String message,String ip) throws SQLException {
        SignUpBean signuser = new Gson().fromJson(message, SignUpBean.class);
        UserBean user = new UserBean(ip, signuser.getUsername(), signuser.getPassword(), "online", 0);
        dataAccessLayer.signUp(user);
    }

}
