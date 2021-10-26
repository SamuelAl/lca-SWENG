public class LCA {
   
    private final EdgeWeightedDigraph graph;

    public LCA(EdgeWeightedDigraph graph) {
        if (graph.vertexCount() < 1)
            throw new IllegalArgumentException("Empty graph");
        
            this.graph = graph;
        //TODO(samalarco): pre-process graph to eas LCA finding.
    }

    public int[] findLCA(int nodeA, int nodeB) {
        //TODO(samalarco): Implement findLCA function.
        return new int[]{0};
    }

    
}
