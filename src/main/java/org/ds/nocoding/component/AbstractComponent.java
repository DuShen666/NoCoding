package org.ds.nocoding.component;

import org.ds.nocoding.Component;
import org.ds.nocoding.Point;
import org.ds.nocoding.Property;

import java.util.*;

public abstract class AbstractComponent implements Component {
    protected Component next;
    protected Set<Property> properties;
    protected Map<String,Point> points = new HashMap<>();

    protected AbstractComponent(){}

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

    @Override
    public void putPoint(Point point) {
        points.put(point.getName(),point);
    }

    @Override
    public Map<String,Point> getPoints() {
        return points;
    }

    @Override
    public Point getPoint(String name) {
        return points.get(name);
    }
}
