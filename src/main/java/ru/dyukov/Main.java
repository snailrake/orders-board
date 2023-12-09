package ru.dyukov;

import ru.dyukov.controller.OrderController;
import ru.dyukov.dao.DbFunctions;
import ru.dyukov.model.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.postgresql.ds.PGSimpleDataSource;

public class Main {
    public static void main(String[] args) throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/orders_board");
        dataSource.setUser("postgres");
        dataSource.setPassword("1234");
        try (Connection con = dataSource.getConnection()) {
            if (con == null) {
                System.out.println("Connection failed");
            }
            DbFunctions dao = new DbFunctions(con);
            OrderController orderController = new OrderController(dao);
            orderController.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

