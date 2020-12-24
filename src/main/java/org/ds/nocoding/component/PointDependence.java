package org.ds.nocoding.component;

import org.ds.nocoding.AbstractPoint;
import org.ds.nocoding.Component;

/**
 * 12/24/20 12:20 PM
 *
 * @author duwenbo
 */
public class PointDependence extends AbstractPoint {

    private Component to;
    private Component from;

    @Override
    public void lineTo(Component from, Component to) {
        this.from = from;
        this.to = to;
    }

    public Component getFrom() {
        return from;
    }

    public Component getTo() {
        return to;
    }
}
