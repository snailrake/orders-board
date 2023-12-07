package ru.dyukov;

public class Main {
    public static void main(String[] args) {
        DbFunctions db = new DbFunctions();
        db.connectionToDb("exercises", "postgres", "1234");
    }
}
