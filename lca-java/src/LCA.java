public class LCA {
    private int nodeA;
    private int nodeB;
    private TreeNode root;

    private TreeNode solution;

    public LCA(int nodeA, int nodeB, TreeNode root) {
        if (root == null) throw new IllegalArgumentException("Must provide a valid root");
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.root = root;
    }

    public TreeNode getLCA() {
        if (solution != null) return solution;
        getLCARecursive(root);
        return solution;
    }

    private int getLCARecursive(TreeNode curr) {
        if (curr == null) return 0; 
        int count = 0;
        
        if (curr.value == this.nodeA || curr.value == this.nodeB) count++;

        for (TreeNode child : curr.children) {
            count += getLCARecursive(child);
            if (count >= 2 && solution == null) {
                solution = curr;
                return count;
            }
        }
        return count;
    }
}
