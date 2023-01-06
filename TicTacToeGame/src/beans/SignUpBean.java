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
    
    private String username;
    private String password;
    private String confirmpassword;

    public SignUpBean(String username, String password, String confirmpassword) {
        this.username = username;
        this.password = password;
        this.confirmpassword = confirmpassword;
    }
    
    public boolean checkPassword(String password, String confirmpassword) { 
        if(password.equals(confirmpassword))
            return true;
        else
            return false;
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
