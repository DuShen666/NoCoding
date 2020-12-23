package org.ds.nocoding.component;

import com.dd.Component;

public interface Controller extends Component {

    void doService(ServerRequest request,ServerResponse response);

}
