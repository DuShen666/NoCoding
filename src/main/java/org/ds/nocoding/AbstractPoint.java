package org.ds.nocoding;

/**
 * 12/24/20 12:14 PM
 *
 * @author duwenbo
 */
public abstract class AbstractPoint<T, V> implements Point {

    protected String name;

    protected Boolean necessary;

    protected AbstractPoint(String name, Boolean necessary) {
        this.name = name;
        this.necessary = necessary;
    }

    protected AbstractPoint(String name) {
        this(name, Boolean.FALSE);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Boolean necessary() {
        return necessary;
    }

}
