package com.example.practice.mvc.controller;

import com.example.practice.mvc.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserListController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("users", UserRepository.findAll());
        return "/user/list";
    }

}
