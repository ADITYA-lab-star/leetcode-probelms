public class L63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // Array for the previous row
        int[] prev = new int[n];

        // Iterate through rows
        for (int i = 0; i < m; i++) {
            // Array for the current row
            int[] temp = new int[n];

            for (int j = 0; j < n; j++) {
                
                if (obstacleGrid[i][j]==1) {
                    temp[j] = 0;
                    continue;
                }
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
