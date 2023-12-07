package ru.dyukov;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbFunctions {
    public Connection connectionToDb(String dbname, String user, String pass) {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (con != null) {
                System.out.println("Connection established");
            }
            else {
                System.out.println("Connection failed");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}

