package ru.dyukov.model;

import java.time.LocalDate;

public class Order {
    private int id;
    private LocalDate date;

    public Order() {
        this.date = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }
}
