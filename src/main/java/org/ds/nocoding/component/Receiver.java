package org.ds.nocoding.component;

public class Receiver extends AbstractComponent {
    private PointOut out;
    protected Receiver(String name) {
        super(name);
        out = new PointOut("out");
        putPoint(out);
    }


    public void work(ServerRequest request,ServerResponse response){
        out.out(request,response);
    }
}
