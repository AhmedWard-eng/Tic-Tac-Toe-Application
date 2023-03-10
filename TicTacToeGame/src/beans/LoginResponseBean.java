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
    private int score;
    ArrayList<UserOnline> users;
    private String msg;

    public LoginResponseBean(String operation, String userName, int score, ArrayList<UserOnline> users, String msg) {
        this.operation = operation;
        this.userName = userName;
        this.score = score;
        this.users = users;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    
}
