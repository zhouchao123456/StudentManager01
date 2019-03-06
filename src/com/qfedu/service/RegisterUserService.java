package com.qfedu.service;

public interface RegisterUserService {
    public void userRegister(String username,String password,String email);

    public void userActive(String linsenceCode);
}
