package com.rest.service;

import java.util.List;

import com.rest.models.Menu;
import com.rest.repository.MenuRepository;

public class MenuService {

    private final MenuRepository repository;

    public MenuService() {
        repository = new MenuRepository();
    }

    public List<Menu> getAll() {
        return repository.getAll();
    }

    public Menu getById(int id) {
        return repository.findById(id);
    }
}