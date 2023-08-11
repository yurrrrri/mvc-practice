package com.example.practice.mvc.controller;

import com.example.practice.mvc.model.User;
import com.example.practice.mvc.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserCreateController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
        UserRepository.save(new User(req.getParameter("userId"), req.getParameter("name")));
        return "redirect:/users";
    }

}
