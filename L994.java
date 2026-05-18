
public class L994 {
    void dfs(int[][] grid, int m, int i, int j) {
        
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int max=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    if (i>0) {
                        
                    }
                    dfs(grid, max+1, i, j);
                }
            }
        }
    
        return max;
    }
}
