package org.ds.nocoding.permission;//package com.org.ds.nocoding.permission;
//
//import com.org.ds.nocoding.AbstractFilter;
//import com.org.ds.nocoding.Component;
//import com.org.ds.nocoding.cache.CacheProcesser;
//import com.org.ds.nocoding.logging.Log;
//import com.org.ds.nocoding.logging.LogFactory;
//
//public class PermissionFilter extends AbstractFilter {
//
//    private static final Log log = LogFactory.getLog(PermissionFilter.class);
//
//    private final CacheProcesser cacheProcesser;
//
//    public PermissionFilter(CacheProcesser cacheProcesser){
//        this.cacheProcesser=cacheProcesser;
//    }
//
//    @Override
//    protected void process(Object in, Object out) {
//        cacheProcesser.put("test","测试缓存key");
//        log.debug("cache test "+cacheProcesser.get("test",String.class));
//        log.debug("in:"+in);
//        log.debug("out:"+out);
//    }
//}
