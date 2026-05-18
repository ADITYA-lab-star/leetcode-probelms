public class L121 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int front = prices[0];
        int min = prices[0];

        int n = prices.length;
        for (int i = 0; i < n; i++) {
            front = prices[i];
            if (min > front) {
                min = front;
            }
            if (profit<front-min) {
                profit = front - min;
            }
            
        }
        
        return profit;
    }
}