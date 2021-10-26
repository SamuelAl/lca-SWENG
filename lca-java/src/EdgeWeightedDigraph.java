import java.util.*;
/**
 * @author  Samuel Alarco Cantos
 * @since   31/3/2021
 */
public class EdgeWeightedDigraph {

    private int vertices;
    private int edges;
    private Map<Integer, Set<DirectedEdge>> adjMap;

    // Constructor
    public EdgeWeightedDigraph(int vertices) {
        adjMap = new HashMap<Integer, Set<DirectedEdge>>(vertices);
        this.vertices = vertices;
        this.edges = 0;
    }

    /**
     * Adds and edge to the graph representation
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
        
    }

    /**
     * Gets number of vertices in graph
     * @return number of vertices
     */
    public int vertexCount() {
        return vertices;
    }
    
    /**
     * Gets number of edges in graph
     * @return number ofedges
     */
    public int edgeCount() {
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
