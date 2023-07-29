package com.example.practice.order;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Cook {

    private final String name;
    private final int price;

    public Cook(String name, int price) {
        this.name = name;
        this.price = price;
    }

}
