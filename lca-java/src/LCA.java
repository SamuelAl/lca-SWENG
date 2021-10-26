import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

public class LCA {
   
    private final EdgeWeightedDigraph graph;
    private final int[] sources;

    public LCA(EdgeWeightedDigraph graph) {
        if (graph.vertexCount() < 1)
            throw new IllegalArgumentException("Empty graph");
        
        this.graph = graph;
        sources = findSources(this.graph);
    }

    public int[] findLCA(int nodeA, int nodeB) {
        EdgeWeightedDigraph subgraphA = ancestorSubgraph(nodeA);
        EdgeWeightedDigraph subgraphB = ancestorSubgraph(nodeB);
        
        // Perform vertex intersection.
        Set<Integer> vertexIntersection = new TreeSet<Integer>();
        vertexIntersection.addAll(subgraphA.getVertices());
        vertexIntersection.retainAll(subgraphB.getVertices());

        // Perform intersection of edges.
        Set<DirectedEdge> edgeIntersection = new TreeSet<DirectedEdge>();
        edgeIntersection.addAll(subgraphA.getEdges());
        edgeIntersection.retainAll(subgraphB.getEdges());

        // Induce new subgraph from edge intersection.
        EdgeWeightedDigraph commonAncestorsSubgraph = new EdgeWeightedDigraph();
        for (Integer v : vertexIntersection) {
            commonAncestorsSubgraph.addVertex(v);
        }
        for (DirectedEdge e : edgeIntersection) {
            if (vertexIntersection.contains(e.to) || vertexIntersection.contains(e.from))
                commonAncestorsSubgraph.addEdge(e);
        }

        // Find depth of nodes
        Map<Integer, Integer> depths = findNodeDepths(commonAncestorsSubgraph);
        // return ancestors with maximum depth
        int maxDepth = 0;
        int maxCount = 0;
        for (Integer d : depths.values()) {
            if (d > maxDepth) {
                maxDepth = d;
                maxCount = 1;
            }
            else if (d == maxDepth) {
                maxCount++;
            }
        }
        int[] result = new int[maxCount];
        int idx = 0;
        for (Entry<Integer, Integer> entry : depths.entrySet()) {
            if (entry.getValue() == maxDepth) {
                result[idx++] = entry.getKey();
            }
        }
       return result;
    }

    private int[] findSources(EdgeWeightedDigraph graph) {
        Map<Integer, Boolean> isSource = new HashMap<Integer, Boolean>(graph.vertexCount());
        for (Integer v : graph.getVertices()) {
            for (DirectedEdge e : graph.adj(v)) {
                isSource.put(e.to, false);
            }
        }
        int nSources = graph.vertexCount() - isSource.size();
        int[] sources = new int[nSources];
        int idx = 0;
        for (Integer v : graph.getVertices()) {
            if (!isSource.containsKey(v)) {
                sources[idx++] = v.intValue();
            }
        }
        return sources;
    }

    private EdgeWeightedDigraph ancestorSubgraph(int target) {
        EdgeWeightedDigraph subgraph = new EdgeWeightedDigraph();
        for (int source : sources) {
            ancestorSubgraphHelper(source, target, subgraph);
        }
        return subgraph;
    }

    private boolean ancestorSubgraphHelper(int curr, int target, EdgeWeightedDigraph subgraph) {
        if (curr == target) {
            subgraph.addVertex(curr);
            return true;
        } 
        boolean isAncestor = false;
        for (DirectedEdge e : graph.adj(curr)) {
            if (ancestorSubgraphHelper(e.to, target, subgraph)) {
                subgraph.addEdge(e);
                isAncestor = true;
            }
        }
        return isAncestor;
    }

    private Map<Integer, Integer> findNodeDepths(EdgeWeightedDigraph graph) {
        Map<Integer, Integer> depths = new HashMap<Integer, Integer>(graph.vertexCount());
        for (Integer v : findSources(graph)) {
            findNodeDepthsHelper(v, 0, graph, depths);
        } 
        return depths;
    }

    private void findNodeDepthsHelper(Integer v, int depth, EdgeWeightedDigraph graph, Map<Integer, Integer> depths) {
        if (depths.getOrDefault(v, -1) >= depth) return;
        depths.put(v, depth);
        for (DirectedEdge e : graph.adj(v)) {
            findNodeDepthsHelper(e.to, depth+1, graph, depths);
        }
    }

    
}
