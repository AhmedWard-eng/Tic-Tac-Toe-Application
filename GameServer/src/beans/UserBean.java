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

    public UserBean(String ip, String userName, String pass, String stauts,  int score) {
        this.ip = ip;
        this.userName = userName;
        this.pass = pass;
        this.score = score;
        this.status = stauts;
    }
    
}
