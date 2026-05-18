public class L45 {
    //runtime 11ms
    public int jump(int[] nums) {
        int step = 0;
        int n = nums.length;
        int m = n - 1;
        int j = m;
        int i = n - 2;
        while (m != 0) {
            while (i >= 0) {
                if (nums[i] >= j - i) {
                    m = i;
                }
                i--;
            }
            step++;
            i = m - 1;
            j = m;
        }
        return step;
    }
    
    //runtime less
    public int jumpp(int[] nums) {
        int near = 0, far = 0, jumps = 0;

        while (far < nums.length - 1) {
            int farthest = 0;
            for (int i = near; i <= far; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            near = far + 1;
            far = farthest;
            jumps++;
        }

        return jumps;        
    }

}