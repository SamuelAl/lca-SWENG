import java.util.HashMap;
import java.util.Map;

public class LCA {
   
    private final EdgeWeightedDigraph graph;
    private final int[] sources;

    public LCA(EdgeWeightedDigraph graph) {
        if (graph.vertexCount() < 1)
            throw new IllegalArgumentException("Empty graph");
        
        this.graph = graph;
        //TODO(samalarco): pre-process graph to ease LCA finding.
        sources = findSources();
        
        
    }

    public int[] findLCA(int nodeA, int nodeB) {
        //TODO(samalarco): Implement findLCA function.
        return new int[]{0};
    }

    private int[] findSources() {
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

    
}
