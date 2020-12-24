package org.ds.nocoding.component.impl;

import org.ds.nocoding.component.AbstractComponent;
import org.ds.nocoding.component.Filter;
import org.ds.nocoding.component.Splitter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * 12/24/20 12:53 PM
 *
 * @author duwenbo
 */
public class AuthFilter extends AbstractComponent implements Filter {

    Map<String, Consumer> pointMap = new HashMap<>();

    public AuthFilter(){

    }

    /*
    第一步、new一个单例对象，记作m




     */

    public void test(){

    }

    @FunctionalInterface
    interface Fun{
        void run();
    }


}
