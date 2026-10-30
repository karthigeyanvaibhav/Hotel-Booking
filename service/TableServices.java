package com.rest.service;

import java.util.List;

import com.rest.models.Table;
import com.rest.repository.TableRepository;

public class TableServices {

    private final TableRepository repository;

    public TableServices() {
        repository = new TableRepository();
    }

    public List<Table> getAll() {
        return repository.show();
    }

    public Table getById(int id) {
        return repository.findById(id);
    }

    public boolean bookTable(int id) {

        Table table = repository.findById(id);

        if (table == null) {
            return false;
        }

        if (table.getStatus() == Table.Availability.occupy) {
            return false;
        }

        table.booking();

        return true;
    }

    public void freeTable(int id) {

        Table table = repository.findById(id);

        if (table != null) {
            table.freeNow();
        }
    }
}