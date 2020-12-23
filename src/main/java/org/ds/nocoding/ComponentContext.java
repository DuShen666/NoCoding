package org.ds.nocoding;

public interface ComponentContext {
    Component getComponent(String id);

    boolean containsComponent(String id);
}
