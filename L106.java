import java.util.HashMap;
import java.util.Map;

public class L106 {
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
 
    private int postorderIndex;
    private Map<Integer, Integer> mapping;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        mapping = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mapping.put(inorder[i], i);
        }

        postorderIndex = inorder.length - 1;
        return build(postorder, 0, inorder.length - 1);        
    }

    private TreeNode build(int[] postorder, int start, int end) {
        if (start > end) return null;

        int rootVal = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootVal);
        int mid = mapping.get(rootVal);

        root.left = build(postorder, start, mid - 1);
        root.right = build(postorder, mid + 1, end);

        return root;
    }
}
