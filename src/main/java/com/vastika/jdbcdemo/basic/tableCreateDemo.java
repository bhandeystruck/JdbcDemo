package com.vastika.jdbcdemo.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class tableCreateDemo {
    //so to connect the database we need a URL
    public static final String DB_URL = "jdbc:mysql://localhost:3306/demo_db";

    public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "root1234";
    public static final String SQL ="create table user_table(id int not null auto_increment, user_name varchar(45), password varchar(45), primary key(id))";

    public static void main(String[] args) {

        //first thing
        try (Connection con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                Statement state =con.createStatement();
        ){
            //4. execute the query
            state.executeUpdate(SQL);
            System.out.println("Table created");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
