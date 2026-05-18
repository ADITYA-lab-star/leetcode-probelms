import java.util.ArrayList;
import java.util.List;

public class L228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> m = new ArrayList<>();
        int n = nums.length;
        if (n == 1) {
            m.add(Integer.toString(nums[0]));
        }

        int c = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                if (i - c == 0) {
                    m.add(Integer.toString(nums[c]));
                } else {
                    m.add(Integer.toString(nums[c]) + "->" + Integer.toString(nums[i]));
                }
                c = i + 1;
                if (i == n - 2) {
                    m.add(Integer.toString(nums[c]));
                }
            } else if ((i == n - 2) && (nums[i] + 1 == nums[i + 1])) {
                m.add(Integer.toString(nums[c]) + "->" + Integer.toString(nums[i + 1]));
            }
        }
        return m;
    }

    //faster solution
    public List<String> summaryRange(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;

        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (start == i - 1)
                    res.add(String.valueOf(nums[start]));
                else
                    res.add(nums[start] + "->" + nums[i - 1]);
                start = i;
            }
        }

        // Final range
        if (start == nums.length - 1)
            res.add(String.valueOf(nums[start]));
        else
            res.add(nums[start] + "->" + nums[nums.length - 1]);

        return res;
    }
}