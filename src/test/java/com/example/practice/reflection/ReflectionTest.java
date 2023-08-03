package com.example.practice.reflection;

import com.example.practice.reflection.annotation.Controller;
import com.example.practice.reflection.annotation.Service;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class ReflectionTest {

    @Test
    void scanTest() {
        Set<Class<?>> beans = getTypesAnnotatedWith(List.of(Controller.class, Service.class));
        System.out.println(beans);
        assertThat(beans).hasSize(2);
    }

    private Set<Class<?>> getTypesAnnotatedWith(List<Class<? extends Annotation>> annotations) {
        Reflections reflections = new Reflections("com.example.practice.reflection");
        Set<Class<?>> beans = new HashSet<>();

        annotations.forEach(a -> beans.addAll(reflections.getTypesAnnotatedWith(a)));

        return beans;
    }

}
