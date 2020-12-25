package org.ds.nocoding.cache;

import org.ds.nocoding.component.AbstractComponent;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DefaultCacheProcesser extends AbstractComponent implements CacheProcesser {

    private final Map<String, Object> CACHE = new HashMap<>();

    protected DefaultCacheProcesser(String name) {
        super(name);
    }

    @Override
    public void put(String key, Object value) {
        CACHE.put(key, value);
    }

    @Override
    public Object get(String key) {
        return CACHE.get(key);
    }

    @Override
    public Object get(String key, Class<?> clazz) {
        return clazz.cast(CACHE.get(key));
    }

}