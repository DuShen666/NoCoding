package org.ds.nocoding;

import org.ds.nocoding.component.Receiver;
import org.ds.nocoding.component.ServerRequest;
import org.ds.nocoding.component.ServerResponse;

import java.util.Collection;

/**
 * 12/25/20 2:51 PM
 *
 * @author duwenbo
 */
public class RequestProcessor {

    private final ApplicationContext applicationContext;

    public RequestProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    public void process(ServerRequest request, ServerResponse response) {
        Receiver main = MainComponent();
        if (main==null){
            System.out.println("没有入口");
            return;
        }
        main.work(request,response);

    }

    private Receiver MainComponent(){
        Collection<Component> values = applicationContext.getComponents().values();
        for (Component value : values) {
            if (value instanceof Receiver){
                return (Receiver)value;
            }
        }
        return null;
    }


}
