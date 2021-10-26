public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Finding LCA!");

        EdgeWeightedDigraph graph = createTestDigraph();
        LCA lca = new LCA(graph);
        for (int v : lca.findLCA(6, 7)) {
            System.out.println(v);
        }
    }

    public static EdgeWeightedDigraph createTestDigraph() {
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
