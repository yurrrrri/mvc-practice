package com.example.practice.order;

public class Chef {

    public Cook cook(MenuItem menuItem) {
        Cook cook = new Cook(menuItem);
        return cook;
    }

}
