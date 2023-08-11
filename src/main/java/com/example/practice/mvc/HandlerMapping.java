package com.example.practice.mvc;

public interface HandlerMapping {
    Object findHandler(HandlerKey handlerKey);
}
