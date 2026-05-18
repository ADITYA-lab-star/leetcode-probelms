
import com.sun.source.tree.Tree;

public class L114 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    
    public void flatten(TreeNode root) {
    TreeNode current = root;
    while (current != null) {
        if (current.left != null) {
            TreeNode predecessor = current.left;
            // Find the rightmost node of the left subtree
            while (predecessor.right != null) {
                predecessor = predecessor.right;
            }
            // Connect the right subtree to the rightmost node
            predecessor.right = current.right;
            // Move the left subtree to the right
            current.right = current.left;
            current.left = null;
        }
        // Move to the next node
        current = current.right;
    }
}
}