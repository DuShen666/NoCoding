package org.ds.nocoding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 12/24/20 12:14 PM
 *
 * @author duwenbo
 */
public class ComponentPoint implements Point {

    private OnRequestListener onRequestListener;

    private String name;

    private List<Edge> edgeList = new ArrayList<>();//到该顶点邻接点的边,实际以java.util.LinkedList存储

    public ComponentPoint(String name) {
        this.name = name;
    }


    @Override
    public String name() {
        return name;
    }

    @Override
    public Iterator<Point> getNeighborInterator() {
        return new NeighborIterator();
    }

    @Override
    public boolean connect(Point target) {
        // 将"边"(边的实质是顶点)插入顶点的邻接表
        boolean result = false;
        if (!this.equals(target)) {//顶点互不相同
            Iterator<Point> neighbors = this.getNeighborInterator();
            boolean duplicateEdge = false;
            while (neighbors.hasNext()) {//保证不添加重复的边
                Point nextNeighbor = neighbors.next();
                if (target.equals(nextNeighbor)) {
                    duplicateEdge = true;
                    break;
                }
            }
            if (!duplicateEdge) {
                edgeList.add(new Edge(target));//添加一条新边
                result = true;
            }
        }
        return result;
    }

    @Override
    public OnRequestListener getOnRequestListener() {
        return onRequestListener;
    }

    @Override
    public void setOnRequestListener(OnRequestListener listener) {
        this.onRequestListener = listener;
    }

    /**
     * Task: 这里用了一个单独的类来表示边,主要是考虑到带权值的边
     * 可以看出,Edge类封装了一个顶点和一个double类型变量
     * 若不需要考虑权值,可以不需要单独创建一个Edge类来表示边,只需要一个保存顶点的列表即可
     *
     * @author hapjin
     */
    protected class Edge implements java.io.Serializable {
        private Point vertex;// 终点

        //Vertex 类本身就代表顶点对象,因此在这里只需提供 endVertex，就可以表示一条边了
        protected Edge(Point endVertex) {
            vertex = endVertex;
        }

        protected Point getEndVertex() {
            return vertex;
        }
    }

    /**
     * Task: 遍历该顶点邻接点的迭代器--为 getNeighborInterator()方法 提供迭代器
     * 由于顶点的邻接点以边的形式存储在java.util.List中,因此借助List的迭代器来实现
     * 由于顶点的邻接点由Edge类封装起来了--见Edge.java的定义的第一个属性
     * 因此，首先获得遍历Edge对象的迭代器,再根据获得的Edge对象解析出邻接点对象
     */
    private class NeighborIterator implements Iterator<Point> {

        Iterator<Edge> edgesIterator;

        private NeighborIterator() {
            edgesIterator = edgeList.iterator();//获得遍历edgesList 的迭代器
        }

        @Override
        public boolean hasNext() {
            return edgesIterator.hasNext();
        }

        @Override
        public Point next() {
            Point nextNeighbor = null;
            if (edgesIterator.hasNext()) {
                Edge edgeToNextNeighbor = edgesIterator.next();//LinkedList中存储的是Edge
                nextNeighbor = edgeToNextNeighbor.getEndVertex();//从Edge对象中取出顶点
            } else
                throw new NoSuchElementException();
            return nextNeighbor;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
