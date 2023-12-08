package ru.dyukov.controller;

import ru.dyukov.dao.DbFunctions;
import ru.dyukov.model.Order;
import ru.dyukov.view.Console;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class OrderController {
    private DbFunctions dao;
    public OrderController(DbFunctions dao) {
        this.dao = dao;
    }
    public void run() throws SQLException, IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            Console.showLogin();
            int choise = scanner.nextInt();
            switch (choise) {
                case 1 -> {
                    Console.showUserMenu();
                    int userChoise = scanner.nextInt();
                    switch (userChoise) {
                        case 1 -> Console.showPreparingOrders(dao.getPreparingOrders());
                        case 2 -> Console.showCompletedOrders(dao.getCompletedOrders());
                        case 3 -> dao.doOrder();
                        case 123 -> {
                            exit = true;
                        }
                        default -> exit = true;
                    }
                }
                case 2 -> {
                    Console.showAdminMenu();
                    int adminChoise = scanner.nextInt();
                    switch (adminChoise) {
                        case 1 -> Console.showPreparingOrders(dao.getPreparingOrders());
                        case 2 -> {
                            Console.showTransferDialog();
                            int orderID = scanner.nextInt();
                            Order order = new Order(orderID);
                            dao.doOrderReady(order);
                        }
                        default -> exit = true;
                    }
                }
                case 123 -> {
                    exit = true;
                }
                default -> exit = true;
            }
        }
    }
}
