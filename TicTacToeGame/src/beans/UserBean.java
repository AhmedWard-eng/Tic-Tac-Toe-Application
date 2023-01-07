/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author AhmedWard
 */
public class UserBean {

    public String ip;
    public String userName;
    public String pass;
    public int score;
    public String status;

    public UserBean(String ip, String userName, String pass, String stauts, int score) {
        this.ip = ip;
        this.userName = userName;
        this.pass = pass;
        this.status = stauts;
        this.score = score;

    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public String getUserName() {
        return userName;
    }

    public String getPass() {
        return pass;
    }

    public int getScore() {
        return score;
    }

    public String getStatus() {
        return status;
    }

}
