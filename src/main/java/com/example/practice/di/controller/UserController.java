package com.example.practice.di.controller;

import com.example.practice.di.annotation.Controller;
import com.example.practice.di.annotation.Inject;
import com.example.practice.di.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

}
