package org.ds.nocoding;

import java.util.List;

public interface ComponentFactory {
    Component create(String className);
    Component create(String className, List<Object> args);
}
