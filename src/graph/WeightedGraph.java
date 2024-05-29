package graph;

import points.Edge;

import java.util.*;

public class WeightedGraph<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, List<Edge<Vertex>>> adjacencyMap;

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
        adjacencyMap = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        if (!adjacencyMap.containsKey(v)) {
            adjacencyMap.put(v, new LinkedList<Edge<Vertex>>());
        }
    }

    public void addEdge(Vertex source, Vertex dest, double weight) {
        if (!adjacencyMap.containsKey(source)) {
            adjacencyMap.put(source, new LinkedList<Edge<Vertex>>());
        }
        if (!adjacencyMap.containsKey(dest)) {
            adjacencyMap.put(dest, new LinkedList<Edge<Vertex>>());
        }

        Edge<Vertex> edge = new Edge<>(source, dest, weight);
        if (!adjacencyMap.get(source).contains(edge)) {
            adjacencyMap.get(source).add(edge);
            if (undirected) {
                if (!adjacencyMap.get(dest).contains(new Edge<>(dest, source, weight))) {
                    adjacencyMap.get(dest).add(new Edge<>(dest, source, weight));
                }
            }
        }
    }

    public boolean hasVertex(Vertex v) {
        if (adjacencyMap.keySet().contains(v)) {
            return true;
        }
        return false;
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
        if (adjacencyMap.keySet().contains(source)) {
            for (Edge<Vertex> edge : adjacencyMap.get(source)) {
                if (edge.getDest().equals(dest)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Edge<Vertex>> adjacencyList(Vertex v) {
        if (adjacencyMap.keySet().contains(v)) {
            return adjacencyMap.get(v);
        }
        return new LinkedList<Edge<Vertex>>();
    }
}
