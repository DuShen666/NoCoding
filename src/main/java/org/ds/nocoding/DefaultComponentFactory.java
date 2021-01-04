package org.ds.nocoding;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DefaultComponentFactory implements ComponentFactory {

    @Override
    public Component create(String name, String className) {
        Component component;
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor(String.class);
            component = (Component)constructor.newInstance(name);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return component;
    }
}
