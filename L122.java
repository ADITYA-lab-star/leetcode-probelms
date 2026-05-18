public class L122 {
    //over usage of brain
    public int maxProfit(int[] prices) {
        int profit = 0;
        int front = prices[0];
        int min = prices[0];

        int n = prices.length;
        if (n == 2 && prices[1] > prices[0]) {
            profit = prices[1] - prices[0];
        }

        for (int i = 1; i < n - 1; i++) {
            front = prices[i];
            if (prices[i - 1] > front) {
                min = front;
            }
            if (prices[i + 1] < front) {
                profit += front - min;
            } else if (i == n - 2) {
                profit += prices[i + 1] - min;
            }
        }
        return profit;
    }
    
    //easy and fasterrr
    public int maxProfi(int[] prices) {
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;        
    }
}
