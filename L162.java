public class L162 {

    //this is O(n) solution
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                if (i == 0 && nums[i] > nums[i + 1]) {
                    return i;
                } else if (i == n - 1 && nums[i] > nums[i - 1]) {
                    return i;
                }
            } else if (nums[i] > nums[i + 1] && nums[i] > nums[i - 1]) {
                return i;
            }
        }
        return 0;
    }
    
    //this is O(log(n)) solution 
    public int findPeakElemen(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;        
    }
                                            
}
