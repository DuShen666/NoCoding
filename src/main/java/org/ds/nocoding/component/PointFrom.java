package org.ds.nocoding.component;

import org.ds.nocoding.AbstractPoint;
import org.ds.nocoding.Component;

/**
 * 12/24/20 12:14 PM
 *
 * @author duwenbo
 */
public class PointFrom extends AbstractPoint {
    private Component from;

    public PointFrom(String name,Boolean necessary){
        super(name,necessary);
    }

    @Override
    public void to(Component from) {
        this.from = from;
    }

    public Component getFrom() {
        return from;
    }
}
