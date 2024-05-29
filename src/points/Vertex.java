package points;

import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private final V data;
    private final Map<Vertex<V>, Double> adjacentVertices;

    public Vertex(V data) {
        this.data = data;
        adjacentVertices = new HashMap<Vertex<V>, Double>();
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        if (!adjacentVertices.containsKey(destination)) {
            adjacentVertices.put(destination, weight);
        } else {
            adjacentVertices.remove(destination);
            adjacentVertices.put(destination, weight);
        }
    }

    public V getData() {
        return data;
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        if (adjacentVertices.isEmpty()) {
            return new HashMap<Vertex<V>, Double>();
        } else {
            Map<Vertex<V>, Double> tempMap = new HashMap<Vertex<V>, Double>();
            for (Map.Entry<Vertex<V>, Double> entry : adjacentVertices.entrySet()) {
                tempMap.put(entry.getKey(), entry.getValue());
            }
            return tempMap;
        }
    }
}
