package org.example;

import org.example.graph.scc.TarjanSCC;
import org.example.util.Graph;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TarjanSCCTest {

    @Test
    void testSimpleCycle() {
        Graph g = new Graph();
        g.n = 3;
        g.addEdge(0, 1, 1);
        g.addEdge(1, 2, 1);
        g.addEdge(2, 0, 1);

        TarjanSCC tarjan = new TarjanSCC(g);
        List<List<Integer>> comps = tarjan.run();

        assertEquals(1, comps.size());
        assertTrue(comps.get(0).containsAll(List.of(0, 1, 2)));
    }

    @Test
    void testTwoSCCs() {
        Graph g = new Graph();
        g.n = 4;
        g.addEdge(0, 1, 1);
        g.addEdge(1, 0, 1);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 2, 1);

        TarjanSCC tarjan = new TarjanSCC(g);
        List<List<Integer>> comps = tarjan.run();

        assertEquals(2, comps.size());
    }
}
