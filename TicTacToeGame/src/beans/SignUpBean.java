/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Nada Hamed
 */
public class SignUpBean {
    private String operation;
    private String username;
    private String password;
    private String confirmpassword;

    public SignUpBean(String operation,String username, String password, String confirmpassword) {
        this.operation=operation;
        this.username = username;
        this.password = password;
        this.confirmpassword = confirmpassword;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }
    

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
    
      
}
