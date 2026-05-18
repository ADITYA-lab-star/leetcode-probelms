public class L34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int low = 0, high = nums.length - 1;
        // Find first occurrence
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (low >= nums.length || nums[low] != target) {
            return res;
        }
        res[0] = low;
        // Find last occurrence
        high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        res[1] = high;
        return res;
    }
}
