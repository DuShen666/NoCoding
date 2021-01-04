package org.ds.nocoding.component;

import org.ds.nocoding.Component;
import org.ds.nocoding.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public abstract class AbstractComponent implements Component {

    private static final Logger logger = LoggerFactory.getLogger(AbstractComponent.class);

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

    @Override
    public void work(ServerRequest request, ServerResponse response) {
        if (logger.isDebugEnabled()){
            logger.debug(getClass().getName()+"#work invoke,hash:"+hashCode());
        }
    }
}
