package com.example.pwdManager;

import java.sql.*;

/*
External library  --> mysql-connector-java-8.0.26.jar
*/
public class Database {
    static String dbName = "testDB";
    static String tableName = "LOGIN_INFO";
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/?user=root&password=password";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/" + dbName;
    static final String user = "root";
    static final String password = "password";

    public static void createDatabaseIfNotExists(String dbName){
        try{
            Connection con = DriverManager.getConnection(URL);
            Statement s = con.createStatement();
            s.execute("CREATE DATABASE IF NOT EXISTS "+ dbName);
            s.close();

            System.out.println(dbName + " database created");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void dropDatabaseIfExists(String dbName){
        try{
            Connection con = DriverManager.getConnection(URL);
            Statement s = con.createStatement();
            s.execute("DROP DATABASE IF EXISTS "+ dbName);
            System.out.println(dbName + " database dropped");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void createTable(String tableName){
        try{
            Class.forName(DRIVER);
            String sql= "CREATE TABLE " + tableName +
                        "(id INTEGER not NULL auto_increment, " +
                        " referenceName VARCHAR(40), " +
                        " username VARCHAR(40), " +
                        " password VARCHAR(40), " +
                        " PRIMARY KEY ( id ))";
            Connection con = DriverManager.getConnection(DATABASE_URL, user, password);
            Statement s = con.createStatement();
            s.execute(sql);
            System.out.println(tableName + " table added");
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void masterPassTable(String tableName){
        try{
            Class.forName(DRIVER);
            String sql= "CREATE TABLE " + tableName +
                    "(id INTEGER not NULL auto_increment, " +
                    " masterPassword VARCHAR(128), " +
                    " PRIMARY KEY ( id ))";
            Connection con = DriverManager.getConnection(DATABASE_URL, user, password);
            Statement s = con.createStatement();
            s.execute(sql);
            System.out.println(tableName + " table added");
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void setMasterPassword(){

    }


    public void setDatabaseName(String dbName){
        Database.dbName = dbName;
    }
}
