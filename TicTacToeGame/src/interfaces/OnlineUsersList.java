/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import beans.UserOnline;
import java.util.ArrayList;

/**
 *
 * @author AhmedWard
 */
public interface OnlineUsersList {
    public void getUsers(ArrayList<UserOnline> users);
}
