package org.ds.nocoding.component;

import org.ds.nocoding.Component;
import org.ds.nocoding.Point;
import org.ds.nocoding.Property;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class AbstractComponent implements Component {
    private Component next;
    private Set<Property> properties;
    private Map<String,Point> points = new HashMap<>();

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
        points.put(point.name(),point);
    }

    @Override
    public void putPoint(Point... points) {
        Arrays.stream(points).distinct().forEach(this::putPoint);
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
