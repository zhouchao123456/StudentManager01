package com.qfedu.domain;

public class RegisterUser {
    private String username;
    private String password;
    private String email;
    private String linsence;

    @Override
    public String toString() {
        return "RegisterUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", linsence='" + linsence + '\'' +
                '}';
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinsence() {
        return linsence;
    }

    public void setLinsence(String linsence) {
        this.linsence = linsence;
    }
}
