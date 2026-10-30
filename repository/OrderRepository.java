package com.rest.repository;

import java.util.ArrayList;
import java.util.List;

import com.rest.models.Order;

public class OrderRepository {

    private final List<Order> orders = new ArrayList<>();

    public void save(Order order) {
        orders.add(order);
    }

    public List<Order> getAll() {
        return orders;
    }

    public Order findById(int id) {

        for (Order order : orders) {

            if (order.getId() == id) {
                return order;
            }
        }

        return null;
    }
}