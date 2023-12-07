package ru.dyukov.dao;

import java.sql.*;

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
}

