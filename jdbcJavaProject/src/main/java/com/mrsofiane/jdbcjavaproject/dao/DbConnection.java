package com.mrsofiane.jdbcjavaproject.dao;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
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
//           return connection;
           //Initialize the script runner
           ScriptRunner sr = new ScriptRunner(connection);
           //Creating a reader object
           Reader reader = new BufferedReader(new FileReader("D:\\JavaSimpleCrud\\jdbcJavaProject\\database\\sql_queries.sql"));
           //Running the script
           sr.runScript(reader);
        return connection;

       }catch (SQLException | FileNotFoundException se){
           se.printStackTrace();
           return null;
       }
    }

}
