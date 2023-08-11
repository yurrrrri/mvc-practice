package com.example.practice.mvc;

import com.example.practice.mvc.controller.Controller;
import com.example.practice.mvc.controller.RequestMethod;
import com.example.practice.mvc.view.JspViewResolver;
import com.example.practice.mvc.view.View;
import com.example.practice.mvc.view.ViewResolver;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Slf4j
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    private RequestMappingHandlerMapping rmhm;
    private List<ViewResolver> viewResolvers;

    @Override
    public void init() {
        rmhm = new RequestMappingHandlerMapping();
        rmhm.init();

        viewResolvers = Collections.singletonList(new JspViewResolver());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

        log.info("DispatcherServlet - service started.");

        try {
            Controller handler = rmhm.findHandler(
                    new HandlerKey(RequestMethod.valueOf(req.getMethod()), req.getRequestURI())
            );
            String viewName = handler.handleRequest(req, resp);

            for (ViewResolver viewResolver : viewResolvers) {
                View view = viewResolver.resolveView(viewName);
                view.render(new HashMap<>(), req, resp);
            }

        } catch (Exception e) {
            log.error("exception occurred: [{}]", e.getMessage(), e);
            throw new ServletException(e);
        }
    }

}
