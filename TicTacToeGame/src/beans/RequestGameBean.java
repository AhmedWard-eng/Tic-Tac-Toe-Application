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
public class RequestGameBean {

    public String operation;
    public String myUserName;
    public String otherPlayerUN;
    public String myIp;
    public String otherPlayerIp;
    public int score;

    public RequestGameBean(String operation, String myUserName, String otherPlayerUN, String myIp, String otherPlayerIp,int score) {
        this.otherPlayerIp = otherPlayerIp;
        this.myIp = myIp;
        this.operation = operation;
        this.myUserName = myUserName;
        this.otherPlayerUN = otherPlayerUN;
        this.score = score;
    }

    public RequestGameBean() {
    }

}
