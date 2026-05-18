public class L300 {
    public int lengthOfLIS(int[] nums) {
        int len = 1;
        int n = nums.length;
        int max[] = new int[n];
        max[0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && max[j] >= len) {
                    len = max[j] + 1;
                }
            }
            max[i] = len;
            len = 1;
        }

        for (int i = 0; i < n; i++) {
            if (max[i]>len) {
                len = max[i];
            }
        }
        return len;
    }
}
