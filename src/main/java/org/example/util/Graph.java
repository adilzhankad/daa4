package org.example.util;

import java.util.*;

public class Graph {
    public int n;
    public List<Edge> edges = new ArrayList<>();
    public Map<Integer, List<Edge>> adj = new HashMap<>();

    public void addEdge(int u, int v, int w) {
        edges.add(new Edge(u, v, w));
        adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Edge(u, v, w));
    }
}
