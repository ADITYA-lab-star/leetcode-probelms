public class L129 {

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

    private int bro(TreeNode root, int c) {
        int b = c * 10 + root.val;
        if (root.left != null && root.right != null) {
            return bro(root.left, b) + bro(root.right, b);
        } else if (root.left != null) {
            return bro(root.left, b);
        } else if (root.right != null) {
            return bro(root.right, b);
        } else {
            return b;
        }
    }

    public int sumNumbers(TreeNode root) {
        return bro(root, 0);
    }

}