package org.ds.nocoding.component;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 12/27/20 10:32 PM
 *
 * @author duwenbo
 */
public class HttpServerRequest implements ServerRequest {

    private String requestURI;

    private String method;

    private String version;



    private final Map<String,Object> headers;

    private final Map<String,Object> parameters;

    private HttpServerRequest(String requestURI,Map<String,Object> headers,Map<String,Object> parameters){
        this.requestURI = requestURI;
        this.headers=headers;
        this.parameters=parameters;
    }


    public Object getHeader(String key){
        return headers.get(key);
    }

    public String getRequestURI() {
        return requestURI;
    }

    static class HttpServerRequestFactory{


        public static HttpServerRequest instance(InputStream input){
            StringBuffer requestStringBuffer = new StringBuffer(2048);
            int len = -1;
            byte[] buffer = new byte[2048];
            try{
                len = input.read(buffer);
            } catch (Exception e){
                e.printStackTrace();
            }
            for(int j = 0 ; j < len ; j ++){
                requestStringBuffer.append((char) buffer[j]);
            }
            System.out.println(requestStringBuffer);

            String uri =null; //parseURI(requestStringBuffer.toString());


            return new HttpServerRequest(uri,null,null);

        }
    }

}
