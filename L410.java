public class L410 {
    public int splitArray(int[] nums, int k) {
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum2 += nums[i];
        }
        int j = 0;
        for (int i = 1; i < k; i++) {
            int sum1 = 0;
            while (sum1 + nums[j] < sum2 - nums[j]) {
                sum1 += nums[j];
                sum2 -= nums[j];
                j++;
            }
        }

        return sum2;
    }
}
