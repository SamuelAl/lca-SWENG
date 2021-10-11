import org.junit.Test;
import static org.junit.Assert.*;

public class LCATest {

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyTree() {
        new LCA(0, 0, null);
    }

    @Test
    public void testSimpleTree() {
        // Create single node tree.
        TreeNode root = new TreeNode(0);

        // Test LCA in single node tree.
        LCA lca = new LCA(0,0,root);
        assertEquals("Single node tree", 0, lca.getLCA().value);

        // Test null root is returned if node if LCA cannot be found.
        lca = new LCA(0,1,root);
        assertNull("Missing node", lca.getLCA());
    }

    @Test
    public void testMultiNodalTree() {
        // Create multi-nodal tree.
        TreeNode root = createSampleTree();

        // Test different valid cases in multi-nodal tree.
        LCA lca = new LCA(0, 1, root);
        assertEquals("Root is LCA of itself and descendant", 0, lca.getLCA().value);

        lca = new LCA(1, 2, root);
        assertEquals("Root is LCA of direct descendants", 0, lca.getLCA().value);
        
        lca = new LCA(3, 5, root);
        assertEquals("1 is LCA of 3 and 5", 1, lca.getLCA().value);

        lca = new LCA(2, 5, root);
        assertEquals("0 is LCA of 2 and 5", 0, lca.getLCA().value);

        // Test invalid cases in multi-nodal tree
        lca = new LCA(2, 6, root);
        assertNull("Missing node", lca.getLCA());
    }

    @Test
    public void testDegenerateTree() {
        // Create degenerate tree.
        TreeNode root = createDegenerateTree();

        // Test different valid cases in degenerate tree.
        LCA lca = new LCA(0, 1, root);
        assertEquals("Root is LCA of itself and descendant", 0, lca.getLCA().value);

        lca = new LCA(0, 2, root);
        assertEquals("0 is LCA of itself and descendants", 0, lca.getLCA().value);

        lca = new LCA(1, 2, root);
        assertEquals("1 is LCA of itself and descendant", 1, lca.getLCA().value);

        // Test invalid cases in degenerate tree
        lca = new LCA(2, 6, root);
        assertNull("Missing node", lca.getLCA());
    }

    // Helper methods
    private  TreeNode createSampleTree() {
        /**
         * Creates sample tree structure for tests:
         * 
         *          0
         *         / \
         *        /   \
         *       1     2
         *      /|\
         *     / | \
         *    3  4  5
         */
        

        TreeNode root = new TreeNode(0);
        TreeNode child1 = new TreeNode(1);
        TreeNode child2 = new TreeNode(2);
        TreeNode child3 = new TreeNode(3);
        TreeNode child4 = new TreeNode(4);
        TreeNode child5 = new TreeNode(5);

        root.addChild(child1);
        root.addChild(child2);
        child1.addChild(child3);
        child1.addChild(child4);
        child1.addChild(child5);

        return root;
    }

    private  TreeNode createDegenerateTree() {
        /**
         * Creates sample tree structure for tests:
         * 
         *          0
         *         / 
         *        /   
         *       1     
         *      /
         *     / 
         *    2  
         */
        

        TreeNode root = new TreeNode(0);
        TreeNode child1 = new TreeNode(1);
        TreeNode child2 = new TreeNode(2);

        root.addChild(child1);
        child1.addChild(child2);

        return root;
    }
   
}
