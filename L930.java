public class L930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        int j = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum > goal && i > j) {
                sum -= nums[j++];
            }
            if (sum == goal) {
                res++;
            }
        }
        return res;
    }
}
