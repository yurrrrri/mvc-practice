package com.example.practice.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ForwardController implements Controller {

    private final String forwardUriPath;

    @Override
    public String handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        return forwardUriPath;
    }

}
