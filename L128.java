import java.util.HashSet;
import java.util.Set;

public class L128 {
    
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;

                while (numSet.contains(num + length)) {
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }

    //this is a better solution
    public int longestConsecutiv(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currLength = 1;
                while (set.contains(num + 1)) {
                    num++;
                    currLength++;
                }
                maxLength = Math.max(maxLength, currLength);
            }
        }
        return maxLength;
    }

}
