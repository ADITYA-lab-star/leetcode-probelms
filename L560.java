public class L560 {
    //this sliding window will not work beacuse you have neagtive nums
    public int subarraySu(int[] nums, int k) {
        int n = nums.length;

        if (n == 1) {
            return nums[0] == k ? 1 : 0;
        }
        
        int res = 0;
        int left = 0;
        int right = 0;
        int sum = 0;

        while (left < n && right < n) {
            sum += nums[right];
            if (sum == k) {
                res++;
            }
            
            while (left < n && (k >= 0 ? sum > k : sum < k)) {
                sum -= nums[left++];
                if (sum == k) {
                    res++;
                }
            }
                        
            right++;
        }

        return res;
    }
}
