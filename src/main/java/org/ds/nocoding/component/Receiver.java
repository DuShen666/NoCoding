package org.ds.nocoding.component;

public class Receiver extends AbstractComponent {
    private PointOut out;
    public Receiver(String name) {
        super(name);
        out = new PointOut("out");
        putPoint(out);
    }


    @Override
    public void work(ServerRequest request, ServerResponse response) {
        super.work(request, response);
        out.out(request,response);
    }
}
