package org.example;

import org.example.graph.scc.TopologicalSortKahn;
import org.example.util.Graph;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TopologicalSortKahnTest {

    @Test
    void testSimpleDAG() {
        Graph g = new Graph();
        g.n = 3;
        g.addEdge(0, 1, 1);
        g.addEdge(1, 2, 1);

        List<Integer> order = TopologicalSortKahn.sort(g);
        assertEquals(List.of(0, 1, 2), order);
    }
}
