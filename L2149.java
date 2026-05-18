public class L2149 {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];

        int pos = 0;
        int neg = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                while (nums[pos] < 0) {
                    pos++;
                }
                res[i] = nums[pos];
                pos++;
            }
            else {
                while (nums[neg] > 0) {
                    neg++;
                }
                res[i] = nums[neg];
                neg++;
            }
        }
        return res;
    }
}
