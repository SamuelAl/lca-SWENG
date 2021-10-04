import java.util.ArrayList;
import java.util.List;

public class TreeNode implements Comparable<TreeNode> {
    public int value;
    public List<TreeNode> children;

    public TreeNode(int value) {
        this.value = value;
        this.children = new ArrayList<TreeNode>();
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    @Override
    public int compareTo(TreeNode o) {
        if (o == null) {
            throw new IllegalArgumentException();
        }
        if (value < o.value)
            return -1;
        else if (value > o.value)
            return 1;
        return 0;
    }
}
