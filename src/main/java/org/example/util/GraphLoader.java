package org.example.util;

import com.google.gson.*;
import java.io.*;
import java.nio.file.*;

public class GraphLoader {
    public static Graph load(String filename) {
        Graph g = new Graph();
        try {
            String json = Files.readString(Path.of(filename));
            JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
            g.n = obj.get("n").getAsInt();
            for (JsonElement e : obj.getAsJsonArray("edges")) {
                JsonObject edge = e.getAsJsonObject();
                g.addEdge(edge.get("u").getAsInt(),
                        edge.get("v").getAsInt(),
                        edge.get("w").getAsInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return g;
    }
}
