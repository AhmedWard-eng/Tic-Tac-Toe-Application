/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class LoginResponseBean {

    private String operation;
    private String userName;
    private String score;
    ArrayList<UserOnline> users;

    public LoginResponseBean(String operation, String userName, String score, ArrayList<UserOnline> users) {
        this.operation = operation;
        this.userName = userName;
        this.score = score;
        this.users = users;
    }

    public ArrayList<UserOnline> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserOnline> users) {
        this.users = users;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

}
