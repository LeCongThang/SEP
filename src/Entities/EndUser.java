package Entities;
// Generated Jun 27, 2016 2:25:48 PM by Hibernate Tools 4.3.1


/**
 * EndUser generated by hbm2java
 */
public class EndUser {


     private String email;
     private String pass;
  
    public EndUser() {
    }

	
    public EndUser(String email, String pass) {
        
        this.email = email;
        this.pass = pass;
    }
    
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
   
}


