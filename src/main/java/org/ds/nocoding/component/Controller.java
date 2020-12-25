package org.ds.nocoding.component;

import org.ds.nocoding.Component;

public interface Controller extends Component {

    void doService(ServerRequest request, ServerResponse response);

}
