/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author HP
 */
public class UserOnline {
    private String ip;
    private String userName;
    private String passwared;
    private String status;
    private int score;

    public UserOnline(String ip, String userName, String passwared, String status, int score) {
        this.ip = ip;
        this.userName = userName;
        this.passwared = passwared;
        this.status = status;
        this.score = score;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswared() {
        return passwared;
    }

    public void setPasswared(String passwared) {
        this.passwared = passwared;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "UserOnline{" + "ip=" + ip + ", userName=" + userName + ", passwared=" + passwared + ", status=" + status + ", score=" + score + '}';
    }
    
    
    
    
    
}
