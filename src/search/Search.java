package search;

import java.util.*;

public abstract class Search<Vertex> {
    protected final Vertex source;
    protected final Set<Vertex> marked;
    protected final Map<Vertex, Vertex> edgeTo;
    protected final Map<Vertex, Double> dist;

    public Search(Vertex source) {
        this.source = source;
        marked = new HashSet<Vertex>();
        edgeTo = new HashMap<Vertex, Vertex>();
        dist = new HashMap<Vertex, Double>();
    }

    public boolean hasPathTo(Vertex v) {
        if (marked.contains(v)) {
            return true;
        }
        return false;
    }

    public List<Vertex> pathTo(Vertex v) {
        if (!hasPathTo(v)) {
            return null;
        }
        List<Vertex> path = new LinkedList<Vertex>();
        for (Vertex x = v; !x.equals(source); x = edgeTo.get(x)) {
            if (!path.contains(x)) {
                path.add(x);
            }
        }
        if (!path.contains(source)) {
            path.add(source);
        }
        Collections.reverse(path);
        return path;
    }

    public double distanceTo(Vertex v) {
        if (dist.containsKey(v)) {
            return dist.get(v);
        }
        return Double.MAX_VALUE;
    }
}
