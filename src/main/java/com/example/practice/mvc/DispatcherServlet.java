package com.example.practice.mvc;

import com.example.practice.mvc.controller.Controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    private RequestMappingHandlerMapping rmhm;

    @Override
    public void init() {
        rmhm = new RequestMappingHandlerMapping();
        rmhm.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

        log.info("DispatcherServlet - service started.");

        try {
            Controller handler = rmhm.findHandler(req.getRequestURI());
            String viewName = handler.handleRequest(req, resp);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher(viewName);
            requestDispatcher.forward(req, resp);

        } catch (Exception e) {
            log.error("exception occured: {}", e.getMessage());
            throw new ServletException(e);
        }
    }

}
