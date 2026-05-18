import java.util.HashMap;
import java.util.Map;

public class L219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> dup = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int val = nums[i];

            if (!dup.containsKey(val)) {
                dup.put(val, i);
            } else {
                if (Math.abs(i - dup.get(val)) <= k) {
                    return true;
                } else {
                    dup.remove(val);
                    dup.put(val, i);
                }
            }
        }
        return false;
    }
    
    //less runtime because of better code
    
    public boolean containsNearbyDuplicat(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (seen.containsKey(val) && i - seen.get(val) <= k) {
                return true;
            }
            seen.put(val, i);
        }

        return false;        
    }

}
