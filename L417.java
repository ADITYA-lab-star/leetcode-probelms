import java.util.ArrayList;
import java.util.List;

public class L417 {
    private boolean pasAt(int arr[][], int i, int j, int r, int c) {
        boolean g = true;
        if (i!=0&&i!=r-1&&j!=0&&j!=c-1) {
            if (arr[i-1][j]<=arr[i][j]) {
                g=(g&pasAt(arr, i, j, r, c))
            }
        }


        return true;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c   = heights[0].length;
        
        List<List<Integer>> lol = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (pasAt(heights, i, j, r, c)) {
                    List<Integer> pass = new ArrayList<>();
                    pass.add(i);
                    pass.add(j);
                    lol.add(pass);
                }
            }
        }
        return lol;
    }
}
