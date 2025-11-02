package org.example;

import org.example.util.Graph;
import org.example.util.GraphLoader;
import org.example.graph.scc.TarjanSCC;
import org.example.graph.scc.CondensationGraph;
import org.example.graph.scc.TopologicalSortKahn;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Loading graph from data/tasks.json ===");

        Graph graph = GraphLoader.load("data/tasks.json");
        System.out.println("Graph loaded: " + graph.n + " vertices, " + graph.edges.size() + " edges");

        // 🔹 Находим SCC
        TarjanSCC tarjan = new TarjanSCC(graph);
        List<List<Integer>> components = tarjan.run();

        System.out.println("\n=== Strongly Connected Components (SCC) ===");
        for (int i = 0; i < components.size(); i++) {
            System.out.println("Component " + (i + 1) + ": " + components.get(i));
        }


        CondensationGraph cond = new CondensationGraph(graph, components);
        cond.printCondensedGraph();


        System.out.println("\n=== Topological Sort of Condensed Graph ===");
        List<Integer> order = TopologicalSortKahn.sort(cond.getCondensedGraph());
        System.out.println(order);

        System.out.println("\n=== Done ===");
    }
}
