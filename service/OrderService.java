package com.rest.service;

import java.util.List;

import com.rest.models.Order;
import com.rest.models.OrderItem;
import com.rest.models.Menu;
import com.rest.repository.OrderRepository;

public class OrderService {

    private final OrderRepository repository;
    private int nextOrderId = 1;

    public OrderService() {
        repository = new OrderRepository();
    }

    public Order createOrder(int tableId) {

        Order order = new Order(nextOrderId++, tableId);

        repository.save(order);

        return order;
    }

    public void addItem(Order order, Menu menu, int quantity) {

        OrderItem item = new OrderItem(menu, quantity);

        order.addItem(item);
    }

    public List<Order> getAll() {
        return repository.getAll();
    }
}