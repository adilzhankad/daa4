package org.example.graph.scc;

import org.example.util.Graph;
import org.example.util.Edge;
import java.util.*;

public class TopologicalSortKahn {

    public static List<Integer> sort(Graph g) {
        int n = g.n;
        int[] indegree = new int[n];
        List<Integer> result = new ArrayList<>();

        // считаем входящие рёбра
        for (List<Edge> list : g.adj.values()) {
            for (Edge e : list) {
                indegree[e.to]++;
            }
        }

        // добавляем вершины без входящих рёбер
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            result.add(u);

            for (Edge e : g.getNeighbors(u)) {
                indegree[e.to]--;
                if (indegree[e.to] == 0) q.add(e.to);
            }
        }

        return result;
    }
}
