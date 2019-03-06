package com.qfedu.service;

public interface FindUser {
    public void addUser(String username,String password);

    public boolean selectUserByUsernameAndPassword(String username,String password);

    public boolean findUserByUsername(String username);
}
