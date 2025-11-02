package org.example.graph.scc;

import org.example.util.Graph;
import org.example.util.Edge;
import java.util.*;

public class TarjanSCC {
    private final Graph graph;
    private int time = 0;
    private final int[] disc;
    private final int[] low;
    private final boolean[] stackMember;
    private final Deque<Integer> stack;
    private final List<List<Integer>> components;

    public TarjanSCC(Graph graph) {
        this.graph = graph;
        int n = graph.n;
        disc = new int[n];
        low = new int[n];
        stackMember = new boolean[n];
        stack = new ArrayDeque<>();
        components = new ArrayList<>();
    }

    public List<List<Integer>> run() {
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        // ✅ начинаем с 0, а не с 1
        for (int i = 0; i < graph.n; i++) {
            if (disc[i] == -1) {
                dfs(i);
            }
        }
        return components;
    }

    private void dfs(int u) {
        disc[u] = low[u] = ++time;
        stack.push(u);
        stackMember[u] = true;

        for (Edge edge : graph.getNeighbors(u)) {
            int v = edge.to;

            if (disc[v] == -1) {
                dfs(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (stackMember[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }


        if (low[u] == disc[u]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int v = stack.pop();
                stackMember[v] = false;
                scc.add(v);
                if (v == u) break;
            }
            components.add(scc);
        }
    }
}
