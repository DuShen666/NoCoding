package org.ds.nocoding;

public interface ApplicationContext {
    Component getComponent(String id);

    boolean containsComponent(String id);
}
