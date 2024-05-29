package graph;

import java.util.*;

public class MyGraph<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, List<Vertex>> adjacencyMap;

    public MyGraph() {
        this(true);
    }

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
        adjacencyMap = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        if (!adjacencyMap.containsKey(v)) {
            adjacencyMap.put(v, new LinkedList<>());
        }
    }

    public void addEdge(Vertex source, Vertex dest) {
        if (!adjacencyMap.containsKey(source)) {
            adjacencyMap.put(source, new LinkedList<>());
        }
        if (!adjacencyMap.containsKey(dest)) {
            adjacencyMap.put(dest, new LinkedList<>());
        }
        if (!source.equals(dest) && !adjacencyMap.get(source).contains(dest)) {
            adjacencyMap.get(source).add(dest);
            if (undirected) {
                if (!adjacencyMap.get(dest).contains(source)) {
                    adjacencyMap.get(dest).add(source);
                }
            }
        }
    }

    public int getVerticesCount() {
        return adjacencyMap.keySet().size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex v : adjacencyMap.keySet()) {
            count += adjacencyMap.get(v).size();
        }
        if (undirected) {
            count /= 2;
        }
        return count;
    }

    public boolean hasVertex(Vertex v) {
        return adjacencyMap.keySet().contains(v);
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
        if (adjacencyMap.keySet().contains(source)) {
            if (adjacencyMap.get(source).contains(dest)) {
                return true;
            }
        }
        return false;
    }

    public List<Vertex> adjacencyList(Vertex v) {
        if (adjacencyMap.keySet().contains(v)) {
            return adjacencyMap.get(v);
        }
        return new LinkedList<>();
    }
}
