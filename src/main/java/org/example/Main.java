package org.example;

import org.example.util.Graph;
import org.example.util.GraphLoader;
import org.example.graph.scc.TarjanSCC;

public class Main {
    public static void main(String[] args) {
        Graph graph = GraphLoader.load("data/tasks.json");
        TarjanSCC scc = new TarjanSCC(graph);
        scc.run();
    }
}
