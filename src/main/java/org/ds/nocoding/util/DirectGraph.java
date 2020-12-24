package org.ds.nocoding.util;

public abstract class DirectGraph extends Graph{

    DirectGraph(int V) {
        super(V);
    }

    @Override
    void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    @Override
    Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
