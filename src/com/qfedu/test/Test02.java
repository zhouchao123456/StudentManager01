package com.qfedu.test;

import com.qfedu.daoImp.SelectStudentDaoImp;
import com.qfedu.serviceImp.FindStudentImp;
import com.qfedu.util.DruidGetConnection;

import java.sql.Connection;

public class Test02 {
    public static void main(String[] args) {
        Connection connection = DruidGetConnection.getConnection();
        SelectStudentDaoImp selectStudentDaoImp = new SelectStudentDaoImp();
        selectStudentDaoImp.setConnection(connection);
        FindStudentImp findStudentImp = new FindStudentImp();
        findStudentImp.setSelectStudentDaoImp(selectStudentDaoImp);
        boolean result = findStudentImp.findStudentByUsername("ll");
        System.out.println(result);
    }
}
