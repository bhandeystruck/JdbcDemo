package com.vastika.jdbcdemo.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {

    //so to connect the database we need a URL
    public static final String DB_URL = "jdbc:mysql://localhost:3306/";

    public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "root1234";

    //need database
    public static final String SQL ="create database demo_db";

    public static void main(String[] args) {
        //2.
        Connection con = null;

        //3.
        Statement state = null;

        //first thing
        try {
            //1.we are registering the driver here
            Class.forName(DRIVER_NAME);
            //2.Obtain connection object
            con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

            //3.Obtain statement object
            state = con.createStatement();

            //4. execute the query
            state.executeUpdate(SQL);

            System.out.println("DB created");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                //5.
                con.close();
                state.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
