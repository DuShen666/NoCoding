package org.ds.nocoding;

import java.util.Map;

public interface ApplicationContext {
    Component getComponent(String id);

    boolean containsComponent(String id);

    Map<String, Component> getComponents();
}
