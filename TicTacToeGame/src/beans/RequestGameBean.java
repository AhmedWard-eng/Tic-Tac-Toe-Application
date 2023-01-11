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

    public RequestGameBean(String operation, String userName, ,String myIp, String otherPlayerIp) {
        this.otherPlayerIp = otherPlayerIp;
        this.myIp = myIp;
        this.operation = operation;
        this.myUserName = userName;
    }

}
