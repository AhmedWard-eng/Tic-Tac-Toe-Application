/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class UsersResponseBean {
    String operation;
    ArrayList<UserOnline> users;

    public UsersResponseBean(String operation, ArrayList<UserOnline> users) {
        this.operation = operation;
        this.users = users;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public ArrayList<UserOnline> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserOnline> users) {
        this.users = users;
    }
    
}
