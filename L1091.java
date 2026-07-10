import java.util.*;

public class L1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // Edge Case: if the source is the same as the destination
        if ((grid.length == 1) && (grid[0].length == 1)) {
            return 0;
        }

        // Get the grid size
        int n = grid.length;
        int m = grid[0].length;
        int[] destination = { n - 1, m - 1 };

        // Initialize the distance matrix, marking all cells as unvisited initially
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = 0;

        // Create a queue for BFS to store {distance, {row, column}} pairs
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0, 0 }); // Push source cell with distance 0

        // Define the possible directions (up, right, down, left)
        //IN leetcode we added more directions
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        // Start BFS traversal
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int dis = current[0];
            int r = current[1];
            int c = current[2];

            // Check all 4 adjacent directions
            for (int i = 0; i < 4; i++) {
                int newr = r + dr[i];
                int newc = c + dc[i];

                // Check if the new cell is within bounds and is a valid cell (i.e., 1)
                if (newr >= 0 && newr < n && newc >= 0 && newc < m && grid[newr][newc] == 1
                        && dis + 1 < dist[newr][newc]) {
                    dist[newr][newc] = dis + 1; // Update the distance

                    // If destination is reached, return the distance
                    if (newr == destination[0] && newc == destination[1])
                        return dis + 1;

                    // Add the new cell to the queue for further processing
                    q.offer(new int[] { dis + 1, newr, newc });
                }
            }
        }
        return -1;
    }
}
