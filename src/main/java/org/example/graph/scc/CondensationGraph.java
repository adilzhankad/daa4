package org.example.graph.scc;

import org.example.util.Edge;
import org.example.util.Graph;
import java.util.*;

public class CondensationGraph {

    private final Graph original;
    private final List<List<Integer>> components;
    private final Map<Integer, Integer> compIdMap = new HashMap<>(); // node → component ID
    private final Graph condensed = new Graph();

    public CondensationGraph(Graph original, List<List<Integer>> components) {
        this.original = original;
        this.components = components;
        build();
    }

    /**
     * Построение конденсации (DAG на основе компонент)
     */
    private void build() {
        // 1️⃣ Сопоставляем вершины с компонентами
        for (int i = 0; i < components.size(); i++) {
            for (int node : components.get(i)) {
                compIdMap.put(node, i);
            }

        }

        // 2️⃣ Устанавливаем количество вершин в DAG (по числу компонент)
        condensed.n = components.size();

        // 3️⃣ Создаём рёбра между компонентами
        Set<String> uniqueEdges = new HashSet<>();

        for (Edge edge : original.edges) {
            Integer fromComp = compIdMap.get(edge.from);
            Integer toComp = compIdMap.get(edge.to);

            // ⚠️ Если какая-то вершина не попала в компоненту — пропускаем
            if (fromComp == null || toComp == null) {
                System.err.println("⚠️ Warning: missing component for edge " + edge.from + " -> " + edge.to);
                continue;
            }

            // Добавляем ребро между разными компонентами
            if (!fromComp.equals(toComp)) {
                String key = fromComp + "->" + toComp;
                if (uniqueEdges.add(key)) {
                    condensed.addEdge(fromComp, toComp, edge.weight);
                }
            }
        }
    }

    /**
     * Возвращает построенный DAG
     */
    public Graph getCondensedGraph() {
        return condensed;
    }

    /**
     * Возвращает сопоставление: вершина → номер компоненты
     */
    public Map<Integer, Integer> getComponentMap() {
        return compIdMap;
    }

    /**
     * Печатает граф конденсации в консоль
     */
    public void printCondensedGraph() {
        System.out.println("\n=== Condensed Graph (DAG) ===");
        for (int u = 0; u < condensed.n; u++) {
            List<Edge> neighbors = condensed.adj.getOrDefault(u, new ArrayList<>());
            System.out.print("Component " + u + " → ");
            if (neighbors.isEmpty()) {
                System.out.print("(no outgoing edges)");
            } else {
                for (Edge e : neighbors) {
                    System.out.print("C" + e.to + " ");
                }
            }
            System.out.println();
        }
    }
}
