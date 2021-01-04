package org.ds.nocoding.component;

import org.ds.nocoding.ComponentPoint;

public abstract class AbstractFilter extends AbstractComponent implements Filter {


    protected AbstractFilter(String name) {
        super(name);
        PointIn in = new PointIn("in");
        PointOut out = new PointOut("out");

        in.setOnRequestListener((request, response) -> {
            work(request, response);
            out.out(request, response);
        });

        putPoint(in,out);
    }

}
