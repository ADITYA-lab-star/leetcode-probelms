import java.util.List;

public class L120 {
    // Function to find the minimum path sum
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        // Create an array to store the next row
        int[] front = new int[n];

        // Create an array to store the current row
        int[] cur = new int[n];

        // Initialize front with last row of triangle
        for (int j = 0; j < n; j++) {
            front[j] = triangle.get(n - 1).get(j);
        }

        // Traverse rows from bottom to top
        for (int i = n - 2; i >= 0; i--) {

            // Traverse elements in current row
            for (int j = i; j >= 0; j--) {

                // Calculate path going down
                int down = triangle.get(i).get(j) + front[j];

                // Calculate path going diagonal
                int diagonal = triangle.get(i).get(j) + front[j + 1];

                // Store minimum in current row
                cur[j] = Math.min(down, diagonal);
            }

            // Update front row with current row
            front = cur.clone();
        }

        // Return top element (minimum path sum)
        return front[0];
    }
}
