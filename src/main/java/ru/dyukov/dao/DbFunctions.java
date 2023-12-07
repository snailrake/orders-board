package ru.dyukov.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbFunctions {
    public Connection connectionToDb(String dbname, String user, String pass) throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (con == null) {
                System.out.println("Connection failed");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}

