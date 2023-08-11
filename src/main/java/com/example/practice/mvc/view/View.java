package com.example.practice.mvc.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

public interface View {

    void render(Map<String, ?> model, HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
