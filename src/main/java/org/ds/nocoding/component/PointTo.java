package org.ds.nocoding.component;

import org.ds.nocoding.AbstractPoint;
import org.ds.nocoding.Component;

/**
 * 12/24/20 12:14 PM
 *
 * @author duwenbo
 */
public class PointTo extends AbstractPoint {
    private Component to;

    public PointTo(String name,Boolean necessary){
        super(name,necessary);
    }

    @Override
    public void to(Component to) {
        this.to = to;
    }

    public Component getTo() {
        return to;
    }
}
