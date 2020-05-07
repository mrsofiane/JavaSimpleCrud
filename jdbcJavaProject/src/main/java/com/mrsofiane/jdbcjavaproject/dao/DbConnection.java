package com.mrsofiane.jdbcjavaproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection { // dao : data access object
    private static Connection connection;
    private static final String HOST ="localhost";
    private static final int PORT =3306;
    private static final String DB_NAME ="jdbc_workshop_db";
    private static final String USERNAME ="root";
    private static final String PASSWORD ="";

    public static Connection getConnection(){

       try {
           connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s",HOST,PORT,DB_NAME),USERNAME,PASSWORD);
           return connection;
       }catch (SQLException se){
           se.printStackTrace();
           return null;
       }
    }

}
