package ru.dyukov;

import ru.dyukov.dao.DbFunctions;

public class Main {
    public static void main(String[] args) {
        DbFunctions db = new DbFunctions();
        db.connectionToDb("orders_board", "postgres", "1234");
    }
}
