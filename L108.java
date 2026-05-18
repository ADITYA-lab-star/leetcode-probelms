
import javax.sound.midi.MidiChannel;

public class L108 {

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

    private TreeNode build(int[] arr, int left, int right) {
        if (left >= right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode newNode = new TreeNode(arr[mid]);
        newNode.left = build(arr, left, mid);
        newNode.right = build(arr, mid + 1, right);

        return newNode;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        
        return build(nums, 0, n);
    }
}