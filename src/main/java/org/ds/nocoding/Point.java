package org.ds.nocoding;

import org.ds.nocoding.component.ServerRequest;
import org.ds.nocoding.component.ServerResponse;

import java.util.EventListener;
import java.util.Iterator;

public interface Point {

    String name();

    boolean connect(Point target);

    OnRequestListener getOnRequestListener();

    void setOnRequestListener(OnRequestListener listener);

    Iterator<Point> getNeighborInterator();

    interface OnRequestListener extends EventListener {
        void onRequest(ServerRequest request, ServerResponse response);
    }
}
