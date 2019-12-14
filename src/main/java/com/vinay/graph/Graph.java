package com.vinay.graph;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int vertices;
    private List<Integer> list[];

    public Graph(int vertices) {
        this.vertices = vertices;
        list=new List[vertices];
        for (int i = 0; i < vertices; i++) {
            list[i] = new LinkedList<>();
        }
    }


    public List<Integer>[] getList() {
        return list;
    }

    public void addEdge(int u, int v) {
        list[u].add(v);
    }
}
