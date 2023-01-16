/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author user
 */
public class LogoutWithDrawBean {
    private String ip;
    private String username;
    private String operation;
    private String otherPlayeruserName;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOtherPlayeruserName() {
        return otherPlayeruserName;
    }

    public void setOtherPlayeruserName(String otherPlayeruserName) {
        this.otherPlayeruserName = otherPlayeruserName;
    }

    public LogoutWithDrawBean(String ip, String username, String operation, String otherPlayeruserName) {
        this.ip = ip;
        this.username = username;
        this.operation = operation;
        this.otherPlayeruserName = otherPlayeruserName;
    }
}
