package search;

import graph.MyGraph;
import java.util.*;

public class DepthFirstSearch<Vertex> extends Search<Vertex> {
    public DepthFirstSearch(MyGraph<Vertex> graph, Vertex source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(MyGraph<Vertex> graph, Vertex current) {
        if (!marked.contains(current)) {
            marked.add(current);
        }

        List<Vertex> neighbors = graph.adjacencyList(current);
        for (int i = 0; i < neighbors.size(); i++) {
            Vertex neighbor = neighbors.get(i);
            if (!marked.contains(neighbor)) {
                if (!edgeTo.containsKey(neighbor)) {
                    edgeTo.put(neighbor, current);
                }
                dfs(graph, neighbor);
            }
        }
    }
}
