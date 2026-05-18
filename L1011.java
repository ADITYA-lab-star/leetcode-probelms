public class L1011 {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for (int w: weights) {
            low = Math.max(low, w);
            high += w;
        }
        
        while (low < high) {
            int mid = low + (high - low) / 2;

            int day = 0;
            int curr = 0;

            for (int i = 0; i < weights.length; i++) {
                if (mid < curr + weights[i]) {
                    day++;
                    curr = 0;
                }
                curr += weights[i];
            }

            if (day > days) {
                low = mid + 1;
            } else {
                high = mid ;
            }
        }

        return low;
    }
}
