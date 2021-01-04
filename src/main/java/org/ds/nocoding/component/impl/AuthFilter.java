package org.ds.nocoding.component.impl;

import org.ds.nocoding.component.AbstractComponent;
import org.ds.nocoding.component.AbstractFilter;
import org.ds.nocoding.component.ServerRequest;
import org.ds.nocoding.component.ServerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 12/24/20 12:53 PM
 *
 * @author duwenbo
 */
public class AuthFilter extends AbstractFilter {

    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    public AuthFilter(String name) {
        super(name);
        initOptions();
    }

    private void initOptions(){
        properties().setProperty("HeaderKey","Authorization");
    }

    @Override
    public void work(ServerRequest request, ServerResponse response) {
        super.work(request,response);
        logger.debug("AuthFilter 开始工作了");
    }

}
