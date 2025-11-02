package org.example.metrics;

public class Metrics {
    long start, end;
    int dfsCount, relaxations;

    public void startTimer() { start = System.nanoTime(); }
    public void stopTimer() { end = System.nanoTime(); }
    public long duration() { return end - start; }
}
