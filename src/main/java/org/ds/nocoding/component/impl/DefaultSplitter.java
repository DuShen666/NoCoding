package org.ds.nocoding.component.impl;

import org.ds.nocoding.Property;
import org.ds.nocoding.component.AbstractComponent;
import org.ds.nocoding.component.PointFrom;
import org.ds.nocoding.component.Splitter;

import java.util.Set;

/**
 * 12/24/20 12:26 PM
 *
 * @author duwenbo
 */
public class DefaultSplitter extends AbstractComponent implements Splitter {

    public DefaultSplitter(){
        //默认构造器里构造端点
        PointFrom pointFrom = new PointFrom("in",true);


        putPoint(pointFrom);
    }

}
