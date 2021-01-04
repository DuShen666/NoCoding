package org.ds.nocoding;

import org.ds.nocoding.component.ServerRequest;
import org.ds.nocoding.component.ServerResponse;

import java.util.Map;
import java.util.Properties;

/**
 * 所有的组件必须实现该接口,组件已链表形式存储
 */
public interface Component {

    /**
     * 组件是否是单例
     *
     * @return
     */
    boolean singleton();

    void work(ServerRequest request, ServerResponse response);

    Properties properties();

    String name();

    void putPoint(Point point);

    void putPoint(Point... points);

    Map<String, Point> getPoints();

    Point getPoint(String name);
}
