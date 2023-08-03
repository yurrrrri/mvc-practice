package com.example.practice.reflection.controller;

import com.example.practice.reflection.annotation.Controller;
import com.example.practice.reflection.annotation.RequestMapping;
import com.example.practice.reflection.annotation.RequestMethod;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpServletRequest req, HttpServletResponse res) {
        return "home";
    }
}
