package org.ds.nocoding.component;

import com.dd.Component;

public interface CacheProcesser extends Component {

    void put(String key,Object value);

    Object get(String key);

    Object get(String key,Class<?> clazz);
}
