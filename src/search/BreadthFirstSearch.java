package search;

import graph.MyGraph;
import java.util.*;

public class BreadthFirstSearch<Vertex> extends Search<Vertex> {
    public BreadthFirstSearch(MyGraph<Vertex> graph, Vertex source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(MyGraph<Vertex> graph, Vertex source) {
        Queue<Vertex> queue = new LinkedList<>();
        if (!queue.contains(source)) {
            queue.add(source);
        }
        if (!marked.contains(source)) {
            marked.add(source);
        }

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            List<Vertex> neighbors = graph.adjacencyList(current);
            for (int i = 0; i < neighbors.size(); i++) {
                Vertex neighbor = neighbors.get(i);
                if (!marked.contains(neighbor)) {
                    if (!marked.contains(neighbor)) {
                        marked.add(neighbor);
                    }
                    if (!edgeTo.containsKey(neighbor)) {
                        edgeTo.put(neighbor, current);
                    }
                    if (!queue.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }
        }
    }
}
