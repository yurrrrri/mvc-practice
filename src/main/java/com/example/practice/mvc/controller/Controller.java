package com.example.practice.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
    String handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
