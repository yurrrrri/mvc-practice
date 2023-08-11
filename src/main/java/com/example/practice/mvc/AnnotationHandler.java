package com.example.practice.mvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationHandler {

    private final Class<?> clazz;
    private final Method targetMethod;

    public AnnotationHandler(Class<?> clazz, Method declaredMethod) {
        this.clazz = clazz;
        this.targetMethod = declaredMethod;
    }

    public String handle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
        Object handler = declaredConstructor.newInstance();

        return (String) targetMethod.invoke(handler, req, resp);
    }

}
