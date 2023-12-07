package ru.dyukov.controller;

import ru.dyukov.dao.DbFunctions;
import ru.dyukov.view.Console;

import java.sql.SQLException;
import java.util.Scanner;

public class OrderController {
    private DbFunctions dao;
    public OrderController(DbFunctions dao) {
        this.dao = dao;
    }
    public void run() throws SQLException {
        boolean exit = false;
        while (!exit) {
            Console.showLogin();
            Scanner scanner = new Scanner(System.in);
            int choise = scanner.nextInt();
            switch (choise) {
                case 1 -> {
                    Console.showUserMenu();
                    int userChoise = scanner.nextInt();
                    switch (userChoise) {
                        case 1 -> Console.showPreparingOrders(dao.getPreparingOrders());
                        case 2 -> Console.showCompletedOrders(dao.getCompletedOrders());
                    }
                }
                case 2 -> {
                    Console.showAdminMenu();
                    int adminChoise = scanner.nextInt();
                }
            }
        }
    }
}
