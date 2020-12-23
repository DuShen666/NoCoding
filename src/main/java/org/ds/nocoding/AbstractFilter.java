package org.ds.nocoding;

public abstract class AbstractFilter implements Component {

    protected AbstractFilter next;

    public AbstractFilter getNext() {
        return next;
    }

    public void setNext(AbstractFilter next) {
        this.next = next;
    }

    protected abstract void process(Object in, Object out);

    @Override
    public boolean singleton() {
        return false;
    }
}
