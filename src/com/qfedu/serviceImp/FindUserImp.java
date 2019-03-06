package com.qfedu.serviceImp;

import com.qfedu.daoImp.SelectUserDaoImp;
import com.qfedu.service.FindUser;

public class FindUserImp implements FindUser {
    private SelectUserDaoImp selectUserDaoImp;

    public SelectUserDaoImp getSelectUserDaoImp() {
        return selectUserDaoImp;
    }

    public void setSelectUserDaoImp(SelectUserDaoImp selectUserDaoImp) {
        this.selectUserDaoImp = selectUserDaoImp;
    }

    @Override
    public void addUser(String username, String password) {
        selectUserDaoImp.addUser(username,password);
    }

    @Override
    public boolean selectUserByUsernameAndPassword(String username, String password) {

        return selectUserDaoImp.selectUserByUsernameAndPassword(username,password);
    }

    @Override
    public boolean findUserByUsername(String username) {
        return selectUserDaoImp.selectUserByUsername(username);
    }
}
