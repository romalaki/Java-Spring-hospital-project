package com.example.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDAO implements DAO{
    public Connection conn;

    @Override
    public Connection getConn() {
        String url = "jdbc:mysql://localhost:3306/pz5";
        String user = "root";
        String password = "Data1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn= DriverManager.getConnection(url,user,password);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return conn;
    }
}
