package com.example.practice.order;

public class Customer {

    public void order(String menuName, Menu menu, Chef chef) {
        MenuItem menuItem = menu.choose(menuName);
        Cook cook = chef.cook(menuItem);
    }
}
