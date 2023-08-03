package com.example.practice.reflection;

import com.example.practice.reflection.annotation.Controller;
import com.example.practice.reflection.annotation.Service;
import com.example.practice.reflection.model.User;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Test
    void showClass() {
        Class<User> clazz = User.class;

        System.out.println(clazz.getName());
        System.out.println(Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList()));
        System.out.println(Arrays.stream(clazz.getDeclaredConstructors()).collect(Collectors.toList()));
        System.out.println(Arrays.stream(clazz.getDeclaredMethods()).collect(Collectors.toList()));
    }

    @Test
    void load() throws ClassNotFoundException {
        Class<User> clazz = User.class;

        User user = new User("yurrrrri", "유리");
        Class<? extends User> clazz2 = user.getClass();

        Class<?> clazz3 = Class.forName("com.example.practice.reflection.User");

        assertThat(clazz).isEqualTo(clazz2);
        assertThat(clazz2).isEqualTo(clazz3);
        assertThat(clazz3).isEqualTo(clazz);
    }
}
