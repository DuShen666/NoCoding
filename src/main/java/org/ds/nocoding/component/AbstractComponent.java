package org.ds.nocoding.component;

import org.ds.nocoding.Component;
import org.ds.nocoding.Point;

import java.util.*;

public abstract class AbstractComponent implements Component {
    private String name;
    private Properties properties;
    private Map<String, Point> points = new HashMap<>();

    protected AbstractComponent(String name) {
        this.name=name;
        properties = new Properties();
    }

    @Override
    public Properties properties() {
        return properties;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean singleton() {
        return true;
    }

    @Override
    public void putPoint(Point point) {
        points.put(point.name(), point);
    }

    @Override
    public void putPoint(Point... points) {
        Arrays.stream(points).distinct().forEach(this::putPoint);
    }

    @Override
    public Map<String, Point> getPoints() {
        return points;
    }

    @Override
    public Point getPoint(String name) {
        return points.get(name);
    }
}
