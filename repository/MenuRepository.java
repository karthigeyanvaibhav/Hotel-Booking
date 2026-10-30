package com.rest.repository;

import java.util.ArrayList;
import java.util.List;

import com.rest.models.Menu;

public class MenuRepository {

    private final List<Menu> menuList = new ArrayList<>();

    public MenuRepository() {

        menuList.add(new Menu(1, "Chicken Biryani", 180));
        menuList.add(new Menu(2, "Veg Biryani", 140));
        menuList.add(new Menu(3, "Paneer Butter Masala", 160));
        menuList.add(new Menu(4, "Dosa", 60));
        menuList.add(new Menu(5, "Idli", 40));
        menuList.add(new Menu(6, "Fried Rice", 130));
        menuList.add(new Menu(7, "Noodles", 120));
        menuList.add(new Menu(8, "Fresh Juice", 80));
        menuList.add(new Menu(9, "Ice Cream", 70));
    }

    public List<Menu> getAll() {
        return menuList;
    }

    public Menu findById(int id) {

        for (Menu menu : menuList) {

            if (menu.getId() == id) {
                return menu;
            }
        }

        return null;
    }
}