import java.util.*;
/**
 * @author  Samuel Alarco Cantos
 * @since   31/3/2021
 */
public class EdgeWeightedDigraph {

    private int edges;
    private Map<Integer, Set<DirectedEdge>> adjMap; 

    // Constructor
    public EdgeWeightedDigraph() {
        adjMap = new HashMap<Integer, Set<DirectedEdge>>();
        this.edges = 0;
    }

    /**
     * Adds an edge to the graph representation.
     * @param edge edge to add
     */
    public void addEdge(DirectedEdge edge) {
        int origin = edge.from;
        
        if (adjMap.containsKey(origin)) {
        	int prevCount = adjMap.get(origin).size();
            adjMap.get(origin).add(edge);
            if (adjMap.get(origin).size() > prevCount) edges++; 
        }
        else {
            Set<DirectedEdge> newBag = new TreeSet<DirectedEdge>();
            newBag.add(edge);
            adjMap.put(origin, newBag);
            edges++;
        }
        addVertex(edge.to);
    }
    /**
     * Adds a new vertex to the graph.
     * @param v vertex to add
     */
    public void addVertex(int v) {
        if (!adjMap.containsKey(v)) {
            Set<DirectedEdge> newBag = new TreeSet<DirectedEdge>();
            adjMap.put(v, newBag);
        }
    }

    /**
     * Gets number of vertices in graph
     * @return number of vertices
     */
    public int vertexCount() {
        return adjMap.size();
    }
    
    /**
     * Gets number of edges in graph
     * @return number of edges
     */
    public int edgeCount() {
        return edges;
    }

    /**
     * Gets all vertices in the graph.
     * @return vertices
     */
    public Collection<Integer> getVertices() {
        return adjMap.keySet();
    }

    /**
     * Gets all edges and returns them as a set of edges.
     * @return edges
     */
    public Collection<DirectedEdge> getEdges() {
        Set<DirectedEdge> edges = new TreeSet<DirectedEdge>();
        for (Set<DirectedEdge> edgeSet : adjMap.values()) {
            edges.addAll(edgeSet);
        }
        return edges;
    }

    /**
     * Gets all edges incident to the indicated vertex
     * together with the adjacent vertex information
     * @param v vertex to query
     * @return Set containing edges with adjacent vertices
     */
    public Iterable<DirectedEdge> adj(int v) {
        if (adjMap.containsKey(v)) 
            return adjMap.get(v);

        return new HashSet<DirectedEdge>();
    }

   /**
    * Return edge connecting vertices from and to if it exists
    * @param from vertex 1
    * @param to vertex 2
    * @return edge connecting vertex 1 and 2; null if it doesnt exist
    */
    public DirectedEdge adjTo(int from, int to) {
        if (adjMap.containsKey(from)) {
            for (DirectedEdge edge : adjMap.get(from)) {
                if (edge.to == to) return edge;
            }
        }
        return null;
    }

}
