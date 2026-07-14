public class L64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Create 1D array for previous row
        int[] prev = new int[n];

        // Loop through each row
        for (int i = 0; i < m; i++) {

            // Create temp array for current row
            int[] temp = new int[n];

            // Loop through each column
            for (int j = 0; j < n; j++) {

                // If at the start cell
                if (i == 0 && j == 0) {
                    temp[j] = grid[i][j];
                } else {

                    // Take up direction if valid
                    int up = grid[i][j];
                    if (i > 0)
                        up += prev[j];
                    else
                        up += (int) 1e9;

                    // Take left direction if valid
                    int left = grid[i][j];
                    if (j > 0)
                        left += temp[j - 1];
                    else
                        left += (int) 1e9;

                    // Take minimum of both directions
                    temp[j] = Math.min(up, left);
                }
            }

            // Move current row to previous
            prev = temp;
        }

        // Return result at destination
        return prev[n - 1];
    }
}
