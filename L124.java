import java.util.LinkedList;
import java.util.Queue;

public class L124 {
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

    public int sum = 0;
    Queue<Integer> q = new LinkedList<>();
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        // First recur on left subtree
        inorder(root.left);

        // Now deal with the node
        sum += root.val;
        q.add(root.val);

        // Then recur on right subtree
        inorder(root.right);
    }

    public int maxPathSum(TreeNode root) {
        inorder(root);

        int max = sum;
        int n = q.size();
        int arr[] = new int[n];
        int a =0;
        
        for (int i = 0; i < n; i++) {
            arr[i] = q.poll();
        }
        int right = 0;
        int left = 0;

        while (left!=n) {
            if (arr[right] >= 0) {
                a += arr[right];
            }
            else {
                if (max < a) {
                    max = a;
                }
                left
            }
        }
        

        return max;
    }
}
