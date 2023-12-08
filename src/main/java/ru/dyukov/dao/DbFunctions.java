package ru.dyukov.dao;

import ru.dyukov.model.Order;

import java.sql.*;
import java.time.LocalDate;

public class DbFunctions {
    private Connection connection;
    public DbFunctions(Connection connection) {
        this.connection = connection;
    }
    public ResultSet getPreparingOrders() throws SQLException {
        String query = "SELECT * FROM preparing_orders";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet result = statement.executeQuery();
        return result;
    }
    public ResultSet getCompletedOrders() throws SQLException {
        String query = "SELECT * FROM completed_orders";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet result = statement.executeQuery();
        return result;
    }
    public void doOrder() throws SQLException {
        String query = "INSERT INTO preparing_orders(placement_date) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setDate(1, Date.valueOf(LocalDate.now()));
        statement.executeUpdate();
    }
    public void doOrderReady(Order order) throws SQLException {
        String query = "INSERT INTO completed_orders(order_id, complete_date) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, order.getId());
        statement.setDate(2, Date.valueOf(order.getDate()));
        statement.executeUpdate();
    }
}

