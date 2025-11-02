package org.example.util;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GraphLoader {

    public static Graph load(String filename) {
        Graph g = new Graph();
        try {
            String json = Files.readString(Path.of(filename));
            JSONObject obj = new JSONObject(json);
            g.n = obj.getInt("n");

            JSONArray edges = obj.getJSONArray("edges");
            for (int i = 0; i < edges.length(); i++) {
                JSONObject e = edges.getJSONObject(i);
                int u = e.getInt("u");
                int v = e.getInt("v");
                int w = e.getInt("w");
                g.addEdge(u, v, w);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return g;
    }
}
