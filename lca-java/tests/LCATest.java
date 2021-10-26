import org.junit.Test;
import static org.junit.Assert.*;

public class LCATest {

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyGraph() {
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph();
        new LCA(graph);
    }

    @Test
    public void testTrivialGraph() {
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph();
        graph.addVertex(1);
        LCA lca = new LCA(graph);
        
        assertArrayEquals("Test single node graph.", new int[]{1}, lca.findLCA(1, 1));
    }

    @Test
    public void testDAG() {
        EdgeWeightedDigraph graph = createTestDigraph();
        LCA lca = new LCA(graph);
        
        assertArrayEquals("Node 1 is ancestor of itself.", new int[]{1}, lca.findLCA(1, 1));
        assertArrayEquals("Node 1 is LCA of 1 and 2.", new int[]{1}, lca.findLCA(1, 2));
        assertArrayEquals("Node 1 is LCA of 1 and 5.", new int[]{1}, lca.findLCA(1, 5));
        assertArrayEquals("Node 2 is LCA of 3 and 4.", new int[]{2}, lca.findLCA(3, 4));
        assertArrayEquals("Nodes 3 and 4 are LCA of 5 and 8.", new int[]{3,4}, lca.findLCA(5, 8));
    }

    /**
     * Creates sample digraph to be used in testing.
     * @return Test graph.
     */
    public EdgeWeightedDigraph createTestDigraph() {
        /**
         * Test Graph:
         * 
         *            -->-- 3 ----->-----
         *          /        \            \
         * 1 -->-- 2           -->-- 5     \
         *          \        /              \
         *            -->-- 4 -->----------- 8
         *                 /
         * 6 -->-- 7 -->-- 
         * 
         */

        final int weight = 1; // Constant weight used.

        EdgeWeightedDigraph testGraph = new EdgeWeightedDigraph();
        testGraph.addEdge(new DirectedEdge(1, 2, weight));
        testGraph.addEdge(new DirectedEdge(2, 3, weight));
        testGraph.addEdge(new DirectedEdge(2, 4, weight));
        testGraph.addEdge(new DirectedEdge(3, 5, weight));
        testGraph.addEdge(new DirectedEdge(3, 8, weight));
        testGraph.addEdge(new DirectedEdge(4, 5, weight));
        testGraph.addEdge(new DirectedEdge(4, 8, weight));
        testGraph.addEdge(new DirectedEdge(6, 7, weight));
        testGraph.addEdge(new DirectedEdge(7, 4, weight));
        return testGraph;
    }
   
}
