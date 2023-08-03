package com.example.practice.reflection;

import com.example.practice.reflection.annotation.Controller;
import com.example.practice.reflection.annotation.Service;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class ReflectionTest {

    @Test
    void controllerScan() {
        Reflections reflections = new Reflections("com.example.practice.reflection");
        Set<Class<?>> beans = new HashSet<>();
        beans.addAll(reflections.getTypesAnnotatedWith(Controller.class));
        System.out.println(beans);

        assertThat(beans).hasSize(1);
    }

    @Test
    void serviceScan() {
        Reflections reflections = new Reflections("com.example.practice.reflection");
        Set<Class<?>> beans = new HashSet<>();
        beans.addAll(reflections.getTypesAnnotatedWith(Service.class));
        System.out.println(beans);

        assertThat(beans).hasSize(1);
    }

}
