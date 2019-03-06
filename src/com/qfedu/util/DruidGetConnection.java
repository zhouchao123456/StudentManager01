package com.qfedu.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidGetConnection {
    public static Connection getConnection(){
        Connection connection = null;
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("E:\\java\\IdeaProject\\StudentManager01\\src\\com\\qfedu\\util\\Druid.properties"));
//            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            connection = dataSource.getConnection();
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;

    }
}
