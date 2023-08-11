package com.example.practice.mvc;

import com.example.practice.mvc.controller.Controller;
import com.example.practice.mvc.controller.HomeController;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandlerMapping {

    private Map<String, Controller> mappings = new HashMap<>();

    void init() {
        mappings.put("/", new HomeController());
    }

    public Controller findHandler(String uriPath) {
        return mappings.get(uriPath);
    }

}
