package com.example.practice.di.di;

import com.example.practice.di.annotation.Inject;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.util.Set;

public class BeanFactoryUtils {

    public static Constructor<?> getInjectedConstructor(Class<?> clazz) {
        Set<Constructor> injectedConstructors = ReflectionUtils
                .getAllConstructors(clazz, ReflectionUtils.withAnnotation(Inject.class));

        if (injectedConstructors.isEmpty()) {
            return null;
        }

        return injectedConstructors.iterator().next();
    }

}
