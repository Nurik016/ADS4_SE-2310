package search;

import graph.WeightedGraph;
import points.Edge;
import java.util.*;

public class DijkstraSearch<Vertex> extends Search<Vertex> {
    public DijkstraSearch(WeightedGraph<Vertex> graph, Vertex source) {
        super(source);
        dijkstra(graph, source);
    }

    private void dijkstra(WeightedGraph<Vertex> graph, Vertex source) {
        PriorityQueue<Vertex> pq = new PriorityQueue<>(new Comparator<Vertex>() {
            public int compare(Vertex v1, Vertex v2) {
                return Double.compare(dist.get(v1), dist.get(v2));
            }
        });
        if (!dist.containsKey(source)) {
            dist.put(source, 0.0);
        }
        if (!pq.contains(source)) {
            pq.add(source);
        }

        while (!pq.isEmpty()) {
            Vertex current = pq.poll();
            List<Edge<Vertex>> edges = graph.adjacencyList(current);
            for (int i = 0; i < edges.size(); i++) {
                Edge<Vertex> edge = edges.get(i);
                Vertex neighbor = edge.getDest();
                double newDist = dist.get(current) + edge.getWeight();
                if (newDist < dist.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    if (!dist.containsKey(neighbor) || newDist < dist.get(neighbor)) {
                        dist.put(neighbor, newDist);
                    }
                    if (!edgeTo.containsKey(neighbor) || edgeTo.get(neighbor) != current) {
                        edgeTo.put(neighbor, current);
                    }
                    if (!pq.contains(neighbor)) {
                        pq.add(neighbor);
                    } else {
                        pq.remove(neighbor);
                        pq.add(neighbor);
                    }
                }
            }
        }
    }
}
