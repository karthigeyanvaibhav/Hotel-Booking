package com.rest.service;

import com.rest.models.Bill;
import com.rest.models.Order;
import com.rest.repository.BillRepository;

public class BillService {

    private final BillRepository repository;
    private int nextBillId = 1;

    public BillService() {
        repository = new BillRepository();
    }

    public Bill generateBill(Order order) {

        Bill bill = new Bill(
                nextBillId++,
                order.getId(),
                order.getTotalAmount()
        );

        repository.save(bill);

        return bill;
    }
}