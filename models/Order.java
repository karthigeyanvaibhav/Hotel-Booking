package com.rest.models;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private int tableId;
    private List<OrderItem> items;

    public Order(int id, int tableId) {
        this.id = id;
        this.tableId = tableId;
        this.items = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getTableId() {
        return tableId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double getTotalAmount() {

        double total = 0;

        for (OrderItem item : items) {
            total += item.getTotalPrice();
        }

        return total;
    }

    @Override
    public String toString() {

        String result = "\nOrder ID: " + id +
                "\nTable ID: " + tableId +
                "\n";

        for (OrderItem item : items) {
            result += item + "\n";
        }

        result += "Order Total: Rs. " + getTotalAmount();

        return result;
    }
}