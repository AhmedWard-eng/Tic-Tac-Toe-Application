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
public class LoginBean {
    private String operation;
    private String username;
    private String password;
    

    

    public LoginBean(String status , String username, String password) {
        this.operation = status;
        this.username = username;
        this.password = password;
        
    }

    public String getStatus() {
        return operation;
    }

    public void setStatus(String status) {
        this.operation = status;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

   
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
