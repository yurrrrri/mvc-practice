package com.example.practice.reflection.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class User {
    private String userId;
    private String name;

    public boolean equalsUser(User user) {
        return this.equals(user);
    }
}
