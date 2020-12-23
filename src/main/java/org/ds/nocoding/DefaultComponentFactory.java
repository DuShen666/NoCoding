package org.ds.nocoding;

import java.util.List;

public class DefaultComponentFactory implements ComponentFactory {
    @Override
    public Component create(String className) {
        return null;
    }

    @Override
    public Component create(String className, List<Object> args) {
        return null;
    }
}
