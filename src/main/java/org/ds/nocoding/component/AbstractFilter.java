package org.ds.nocoding.component;

import org.ds.nocoding.ComponentPoint;

public abstract class AbstractFilter extends AbstractComponent implements Filter {


    protected AbstractFilter(String name) {
        super(name);
        ComponentPoint in = new ComponentPoint("in");
        ComponentPoint out = new ComponentPoint("out");

        in.setOnRequestListener((request, response) -> {
            process(request, response);
            out.getOnRequestListener().onRequest(request, response);
        });
    }

    protected abstract void process(ServerRequest request, ServerResponse response);

}
