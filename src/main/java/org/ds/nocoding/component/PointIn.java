package org.ds.nocoding.component;

import org.ds.nocoding.ComponentPoint;

/**
 * 12/24/20 12:14 PM
 *
 * @author duwenbo
 */
public class PointIn extends ComponentPoint {

    public PointIn(String name) {
        super(name);
    }

    @Override
    public void setOnRequestListener(OnRequestListener listener) {
        super.setOnRequestListener(listener);
    }
}
