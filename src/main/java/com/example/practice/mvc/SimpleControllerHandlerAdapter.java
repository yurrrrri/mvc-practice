package com.example.practice.mvc;

import com.example.practice.mvc.controller.Controller;
import com.example.practice.mvc.view.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SimpleControllerHandlerAdapter implements HandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof Controller);
    }

    @Override
    public ModelAndView handle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        String viewName = ((Controller) handler).handleRequest(req, resp);
        return new ModelAndView(viewName);
    }

}
