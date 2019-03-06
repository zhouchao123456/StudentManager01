package com.qfedu.daoImp;

import com.qfedu.dao.SelectUserDao;
import com.qfedu.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class SelectUserDaoImp implements SelectUserDao {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addUser(String username, String password) {
        String sql = "insert into user(username,password) values(?,?)";
        QueryRunner queryRunner = new QueryRunner();
        try {
            queryRunner.update(connection,sql,username,password);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean selectUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from user where username=? and password=?";
        QueryRunner queryRunner = new QueryRunner();
        try {
            User user = queryRunner.query(connection, sql, new BeanHandler<User>(User.class), username, password);
            if(user==null){
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean selectUserByUsername(String username) {
        String sql = "select * from user where username = ?";
        QueryRunner queryRunner = new QueryRunner();
        try {
            User user = queryRunner.query(connection, sql, new BeanHandler<User>(User.class), username);
            if(user==null){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
