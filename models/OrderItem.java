package com.rest.models;

public class OrderItem {

    private Menu menu;
    private int quantity;

    public OrderItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return menu.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return menu.getName() +
                " x " + quantity +
                " = Rs. " + getTotalPrice();
    }
}