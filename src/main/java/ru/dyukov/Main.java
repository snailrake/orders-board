package ru.dyukov;

import ru.dyukov.dao.DbFunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + "orders_board", "postgres", "1234")) {
            if (con == null) {
                System.out.println("Connection failed");
            }
            DbFunctions db = new DbFunctions(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

