package ru.dyukov.view;

import ru.dyukov.model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Console {
    public static void showLogin() {
        System.out.println("1. User");
        System.out.println("2. Admin");
        System.out.println("Exit - q");
    }
    public static void showUserMenu() {
        System.out.println("1. See orders");
        System.out.println("2. See completed orders");
        System.out.println("3. Do order");
        System.out.println("Exit - q");
    }
    public static void showAdminMenu() {
        System.out.println("1. See orders");
        System.out.println("2. Manage orders");
        System.out.println("Exit - q");
    }
    public static void showTransferDialog() {
        System.out.println("Delete order:");
        System.out.println("Exit - q");
    }
    public static void showOrder(Order order) {
        System.out.println(String.format("Order #%d "));
    }
    public static void showOrders(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println(String.format("%d %t", resultSet.getInt(0), resultSet.getString(1)));
        }
        System.out.println("Exit - q");
    }
}
