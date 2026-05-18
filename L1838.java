
import java.util.Arrays;

public class L1838 {
    //fails for high values of res and total
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0;
        int r = 0;
        int res = 0;
        int total = 0;

        while (r < n) {
            total += nums[r];
            while (nums[r] * (r - l + 1) > total + k) {
                total -= nums[l];
                l++;
            }
            if (res < r - l + 1) {
                res = r - l + 1;
            }
            r++;
        }
        return res;
    }

    //run for high values due to long
    public int maxFrequenc(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 0;
        long res = 0, total = 0;

        while (right < nums.length) {
            total += nums[right];

            while (nums[right] * (right - left + 1L) > total + k) {
                total -= nums[left];
                left += 1;
            }

            res = Math.max(res, right - left + 1L);
            right += 1;
        }

        return (int) res;        
    }

}
