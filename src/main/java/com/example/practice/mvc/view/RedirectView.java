package com.example.practice.mvc.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class RedirectView implements View {

    private final String name;
    public static final String DEFAULT_REDIRECT_PREFIX = "redirect:";

    @Override
    public void render(Map<String, ?> model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        resp.sendRedirect(name.substring(DEFAULT_REDIRECT_PREFIX.length()));
    }

}
