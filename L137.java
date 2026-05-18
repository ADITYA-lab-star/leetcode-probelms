public class L137 {
    public int singleNumber(int[] nums) {
        int res = 0;

        for (int n : nums) {
            res=~(res&n);
        }

        return ~res+1;
    }
}
