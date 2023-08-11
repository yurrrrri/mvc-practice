package com.example.practice.mvc;

import java.util.HashMap;
import java.util.Map;

public class AnnotationHandlerMapping implements HandlerMapping {

    private Map<HandlerKey, AnnotationHandler> handlers = new HashMap<>();

    @Override
    public Object findHandler(HandlerKey handlerKey) {
        return handlers.get(handlerKey);
    }

}
