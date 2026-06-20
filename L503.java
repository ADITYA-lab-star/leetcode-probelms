import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class L503 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int res[] = new int[nums.length];

        for (int i = (2*nums.length) - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i%nums.length] >= st.peek()) {
                st.pop();
            }
            res[i%nums.length] = st.isEmpty()?-1:st.peek();
            st.push(nums[i%nums.length]);
        }
        return res;
    }
}
