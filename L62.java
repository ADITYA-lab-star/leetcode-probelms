public class L62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                } else {
                    dp[i][j] = (i - 1 >= 0 ? dp[i - 1][j] : 0) + (j - 1 >= 0 ? dp[i][j - 1] : 0);
                }
            }
        }

        return dp[m - 1][n - 1];
    }
    
     // Function to solve the problem using space optimization
    int func(int m, int n) {
        // Array for the previous row
        int[] prev = new int[n];

        // Iterate through rows
        for (int i = 0; i < m; i++) {
            // Array for the current row
            int[] temp = new int[n];

            for (int j = 0; j < n; j++) {
                // Base case
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }

                // Ways from above and left
                int up = (i > 0) ? prev[j] : 0;
                int left = (j > 0) ? temp[j - 1] : 0;

                // Total ways for current cell
                temp[j] = up + left;
            }

            // Update previous row
            prev = temp;
        }
        return prev[n - 1];
    }
}
