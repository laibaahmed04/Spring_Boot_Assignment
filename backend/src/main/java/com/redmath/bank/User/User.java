package com.redmath.bank.User;

import jakarta.persistence.*;
//import org.springframework.security.core.userdetails.UserDetailsService;

@Entity(name = "users")
public class User{

    @Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String userName;
    private String Password;
    private String Roles;

    public Long getId() {
        return ID;
    }

    public void setId(Long ID) {
        this.ID = ID;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRole() {
        return Roles;
    }

    public void setRole(String Roles) {
        this.Roles = Roles;
    }
    public User() {
        // Default constructor logic, if any.
    }


    public User(Long ID , String userName , String Password,String Roles)

    {
        this.ID = ID;
        this.userName = userName;
        this.Password = Password;
        this.Roles=Roles;
    }



}








