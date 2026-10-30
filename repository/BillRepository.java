package com.rest.repository;

import java.util.ArrayList;
import java.util.List;

import com.rest.models.Bill;

public class BillRepository {

    private final List<Bill> bills = new ArrayList<>();

    public void save(Bill bill) {
        bills.add(bill);
    }

    public List<Bill> getAll() {
        return bills;
    }
}