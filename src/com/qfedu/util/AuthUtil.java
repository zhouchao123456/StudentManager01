package com.qfedu.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class AuthUtil extends Authenticator {

    private String username;
    private String password;

    public AuthUtil(String username,String password){
        this.username = username;
        this.password = password;
    }


    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username,password);
    }
}
