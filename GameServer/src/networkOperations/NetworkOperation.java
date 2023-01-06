/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkOperations;

import DataBaseLayer.DataAccessLayer;
import beans.SignUpBean;
import beans.UserBean;

/**
 *
 * @author AhmedWard
 */
public class NetworkOperation {

    DataAccessLayer dataAccessLayer;

    public NetworkOperation() {

        dataAccessLayer = new DataAccessLayer();
    }

    public void signUp(SignUpBean signUpBean, String hostAddress) {
        UserBean userBean = new UserBean(hostAddress, signUpBean.getUsername(), signUpBean.getPassword(), "Online", 0);
        dataAccessLayer.signUp(userBean);
    }

}
