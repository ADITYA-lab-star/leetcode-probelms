import java.util.Stack;

public class L84 {
    public int largestRectangleArea(int[] heights) {
        int res[] = new int[heights.length];
        int maxArea = 0;

        for (int i = 0; i < res.length; i++) {
            if (maxArea<heights[i]) {
                maxArea = heights[i];
            }
        }
        return maxArea;
    }
}
