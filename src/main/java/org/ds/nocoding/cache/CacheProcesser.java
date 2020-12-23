package org.ds.nocoding.cache;

import org.ds.nocoding.Component;

public interface CacheProcesser extends Component {

    void put(String key,Object value);

    Object get(String key);

    Object get(String key,Class<?> clazz);
}
