package com.example.practice.mvc.controller;

import com.example.practice.mvc.annotation.Controller;
import com.example.practice.mvc.annotation.RequestMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
        return "home";
    }

}
