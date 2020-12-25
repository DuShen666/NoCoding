package org.ds.nocoding.component.impl;

import org.ds.nocoding.ComponentPoint;
import org.ds.nocoding.component.*;

/**
 * 12/24/20 12:53 PM
 *
 * @author duwenbo
 */
public class AuthFilter extends AbstractFilter {

    public AuthFilter(String name) {
        super(name);
        initPoint();
    }

    @Override
    protected void process(ServerRequest request, ServerResponse response) {
        System.out.println("AuthFilter 开始工作了");
    }

    private void initPoint() {
        ComponentPoint a = new PointIn("A");
        ComponentPoint b = new PointOut("B");
        ComponentPoint c = new ComponentPoint("C");

        a.setOnRequestListener((request, response) -> System.out.println("a 进来数据了"));
        b.setOnRequestListener((request, response) -> System.out.println("b 进来数据了"));
        c.setOnRequestListener((request, response) -> System.out.println("c 进来数据了"));

        putPoint(a, b, c);
    }


}
