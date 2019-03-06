package com.qfedu.daoImp;

import com.qfedu.dao.RegisterUserDao;
import com.qfedu.domain.RegisterUser;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class RegisterUserDaoImp implements RegisterUserDao {

    private Connection connection;

    @Override
    public void insertUser(RegisterUser registerUser) {
        String sql = "insert into registeruser(username,password,email,linsence) values(?,md5(?),?,?)";
        QueryRunner queryRunner = new QueryRunner();
        try {
            queryRunner.update(connection,sql,registerUser.getUsername(),registerUser.getPassword(),registerUser.getEmail(),registerUser.getLinsence());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void updateUser(String linsenceCode) {

    }}

