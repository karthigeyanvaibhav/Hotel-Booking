package com.rest.models;

public class Bill {

    private int id;
    private int orderId;
    private double amount;
    private double tax;
    private double totalAmount;

    public Bill(int id, int orderId, double amount) {

        this.id = id;
        this.orderId = orderId;
        this.amount = amount;

        tax = amount * 0.05;
        totalAmount = amount + tax;
    }

    public int getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public double getTax() {
        return tax;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {

        return "\n========== BILL ==========" +
                "\nBill ID: " + id +
                "\nOrder ID: " + orderId +
                "\nAmount: Rs. " + amount +
                "\nTax (5%): Rs. " + tax +
                "\n--------------------------" +
                "\nTotal: Rs. " + totalAmount +
                "\n==========================";
    }
}