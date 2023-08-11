package com.example.practice.mvc.view;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class JspView implements View {

    private final String name;

    @Override
    public void render(Map<String, ?> model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        model.forEach(req::setAttribute);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(name);
        requestDispatcher.forward(req, resp);
    }

}
