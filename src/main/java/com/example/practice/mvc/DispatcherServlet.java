package com.example.practice.mvc;

import com.example.practice.mvc.controller.Controller;
import com.example.practice.mvc.controller.RequestMethod;
import com.example.practice.mvc.view.JspViewResolver;
import com.example.practice.mvc.view.ModelAndView;
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
    private List<HandlerAdapter> handlerAdapters;
    private List<ViewResolver> viewResolvers;

    @Override
    public void init() {
        rmhm = new RequestMappingHandlerMapping();
        rmhm.init();

        handlerAdapters = List.of(new SimpleControllerHandlerAdapter());
        viewResolvers = Collections.singletonList(new JspViewResolver());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

        log.info("DispatcherServlet - service started.");

        try {
            Controller handler = rmhm.findHandler(
                    new HandlerKey(RequestMethod.valueOf(req.getMethod()), req.getRequestURI())
            );

            HandlerAdapter handlerAdapter = handlerAdapters.stream()
                    .filter(ha -> ha.supports(handler))
                    .findFirst()
                    .orElseThrow(() -> new ServletException("No adapter for handler [" + handler + "]"));

            ModelAndView modelAndView = handlerAdapter.handle(req, resp, handler);

            for (ViewResolver viewResolver : viewResolvers) {
                View view = viewResolver.resolveView(modelAndView.getViewName());
                view.render(modelAndView.getModel(), req, resp);
            }

        } catch (Exception e) {
            log.error("exception occurred: [{}]", e.getMessage(), e);
            throw new ServletException(e);
        }
    }

}
