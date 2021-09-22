public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Finding LCA!");

        TreeNode tree = createSampleTree();
        LCA lca = new LCA(3, 5, tree);
        System.out.printf("LCA(3,5) = %d", lca.getLCA().value);
    }

    private static TreeNode createSampleTree() {
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
}
