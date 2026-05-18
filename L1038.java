public class L1038 {
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
    
    int sum = 0;

    private void besco(TreeNode root) {
        if (root == null) {
            return;
        }
        besco(root.right);

        sum += root.val;
        root.val = sum;

        besco(root.left);
    }
    
    public TreeNode bstToGst(TreeNode root) {
        besco(root);

        return root;
    }
    

    //another method
    int pre = 0;
    public TreeNode bstToGs(TreeNode root) {
        if (root.right != null) bstToGst(root.right);
        pre = root.val = pre + root.val;
        if (root.left != null) bstToGst(root.left);
        return root;
    }
}
