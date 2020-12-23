package org.ds.nocoding;

public class AbstractComponentContext implements ComponentContext{


    @Override
    public Component getComponent(String id) {
        return null;
    }

    @Override
    public boolean containsComponent(String id) {
        return false;
    }
}
