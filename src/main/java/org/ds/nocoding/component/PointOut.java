package org.ds.nocoding.component;

import org.ds.nocoding.ComponentPoint;
import org.ds.nocoding.Point;

import java.util.Iterator;

/**
 * 12/24/20 12:14 PM
 *
 * @author duwenbo
 */
public class PointOut extends ComponentPoint {

    public PointOut(String name) {
        super(name);
    }

    public void out(ServerRequest request,ServerResponse response){
        Iterator<Point> neighborIterator = getNeighborInterator();
        while (neighborIterator.hasNext()){
            Point next = neighborIterator.next();
            if (next.getOnRequestListener() != null) {
                next.getOnRequestListener().onRequest(request,response);
            }
        }
    }
}
