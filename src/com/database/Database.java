package com.database;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private Connection connection;

    public Database(){
        try {
            System.out.println("Wait connecting to database...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurance", "root",
                    "root");
            System.out.println("Connected Successfully...");
        } catch (Exception e) {
            System.err.println("Failed to connect to database Reason: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
