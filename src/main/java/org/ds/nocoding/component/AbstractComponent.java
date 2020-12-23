package org.ds.nocoding.component;

import org.ds.nocoding.Component;
import org.ds.nocoding.Property;

import java.util.Set;

public abstract class AbstractComponent implements Component {
    protected Component next;
    protected Set<Property> properties;

    protected AbstractComponent(Set<Property> properties){
        this.properties = properties;
    }

    @Override
    public Set<Property> properties() {
        return properties;
    }

    @Override
    public void setNext(Component next) {
        this.next = next;
    }

    @Override
    public Component getNext() {
        return next;
    }

    @Override
    public boolean singleton() {
        return true;
    }
}
