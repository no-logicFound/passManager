package com.example.pwdManager;

import java.sql.*;

/*
External library  --> mysql-connector-java-8.0.26.jar
*/
public class Database {
    static final String DB_NAME = "testDB";
    static final String loginTableName = "login_info";
    static final String MASTER_PASS_TABLE_NAME = "master_password_holder";
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/?user=root&password=password";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    static final String USER = "root";
    static final String PASSWORD = "password";

    public void createDatabaseIfNotExists(String dbName){
        try{
            Connection con = DriverManager.getConnection(URL);
            Statement s = con.createStatement();
            s.execute("CREATE DATABASE IF NOT EXISTS "+ dbName);
            s.close();

            System.out.println(dbName + " database created"); // TODO: should be removed in final version
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void dropDatabaseIfExists(String dbName){
        try{
            Connection con = DriverManager.getConnection(URL);
            Statement s = con.createStatement();
            s.execute("DROP DATABASE IF EXISTS "+ dbName);
            System.out.println(dbName + " database dropped");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createLoginTable(String tableName){
        try{
            Class.forName(DRIVER);
            String sql= "CREATE TABLE " + tableName +
                        "(id INTEGER not NULL auto_increment, " +
                        " referenceName VARCHAR(40), " +
                        " username VARCHAR(40), " +
                        " password VARCHAR(40), " +
                        " PRIMARY KEY ( id ))";
            Connection con = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            Statement s = con.createStatement();
            s.execute(sql);
//            System.out.println(tableName + " table added");
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void createMasterPassTable(String tableName){
        try{
            Class.forName(DRIVER);
            String sql= "CREATE TABLE " + tableName +
                    "(id INTEGER auto_increment, " +
                    " masterPassword VARCHAR(128) NOT NULL, " +
                    " PRIMARY KEY ( id ))";
            Connection con = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            Statement s = con.createStatement();
            s.execute(sql);
//            System.out.println(tableName + " table added");
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void insertMasterPassIntoTable(String hashMasterPass){
        try{
            Class.forName(DRIVER);
            String sql= "INSERT INTO " + MASTER_PASS_TABLE_NAME + "(masterPassword) " +
                        "VALUES(?);";
            Connection con = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, hashMasterPass);
            prepStatement.execute();
            System.out.println("Master password added");
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public String retrieveMasterPassword(){
        String masterPassword = "";
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            Statement s = con.createStatement();
            String query = "SELECT masterPassword from " + MASTER_PASS_TABLE_NAME;
            ResultSet rs = s.executeQuery(query);
            while(rs.next()){
                masterPassword = rs.getString("masterPassword");
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return masterPassword;
    }
}
