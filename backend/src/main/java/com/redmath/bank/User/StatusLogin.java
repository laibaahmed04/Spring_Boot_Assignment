package com.redmath.bank.User;

public class StatusLogin {

    private String message;
    private boolean status;

    private String role;
    public String getmessage() {
        return message;
    }
    public void setmessage(String message) {
        this.message=message;
    }

    public String getrole() {
        return role;
    }
    public void setrole(String role) {
        this.role= role;
    }


    public boolean getstatus() {
        return status;
    }

    public void setmessage(boolean status) {
       this.status=status;
    }
    StatusLogin(String message , boolean status , String role) {
    this.message=message;
    this.status=status;
    this.role=role;

    }

}
