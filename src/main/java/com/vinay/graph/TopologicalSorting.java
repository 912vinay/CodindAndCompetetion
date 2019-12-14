package com.vinay.graph;

import java.util.Iterator;
import java.util.Stack;

public class TopologicalSorting {


    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(5, 0);
        graph.addEdge(5, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 1);
        graph.addEdge(4, 0);
        boolean visited[] = new boolean[6];

        toplogicalSort(graph, visited);
    }

    private static void toplogicalSort(Graph graph, boolean[] visited) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                toplogicalUtil(i, graph, visited, stack);
            }
        }

        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");

    }

    private static void toplogicalUtil(int v, Graph graph, boolean[] visited, Stack<Integer> stack) {

        visited[v] = true;
        Iterator<Integer> iterator = graph.getList()[v].iterator();
        while (iterator.hasNext()) {
            int t = iterator.next();
            if (!visited[t]) {
                toplogicalUtil(t, graph, visited, stack);
            }
        }
        stack.push(v);
    }


}
