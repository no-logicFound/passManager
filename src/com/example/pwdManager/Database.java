package com.example.pwdManager;

import java.sql.*;

public class Database {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/giraffe";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";


    public static void createDatabase(String dbName){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=password");
            Statement s = con.createStatement();
            s.execute("CREATE DATABASE "+ dbName);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void dropDatabase(String dbName){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=password");
            Statement s = con.createStatement();
            s.execute("DROP DATABASE "+ dbName);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
