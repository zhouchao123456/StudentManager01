package com.qfedu.dao;

public interface SelectUserDao {
    public void addUser(String username,String password);

    public boolean selectUserByUsernameAndPassword(String username,String password);

    public boolean selectUserByUsername(String username);


}
