import java.util.HashMap;
import java.util.Map;

public class L149 {

    //O(n^3)
    // This method returns the maximum number of points that lie on the same line
    // given a set of points represented by the 2D array points
    public int maxPoints(int[][] points) {
        // n is the number of points in the array
        int n = points.length;

        // If there are 0 or 1 points, there is at most one line that can be formed
        // (i.e., the line formed by the single point, or no line if there are no points)
        if (n <= 2)
            return n;

        // Initialize the maximum number of points on a line to 2, since there must be at least 2 points to form a line
        int ans = 2;

        // Iterate through all pairs of points
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // temp is the number of points on the line formed by point i and point j
                int temp = 2;
                // Check if any other points are on the same line as point i and point j
                for (int k = j + 1; k < n; k++) {
                    // Check if point k is on the same line as point i and point j
                    // This is done by checking if the slope between point i and point k is equal to the slope between point i and point j
                    int x = (points[j][1] - points[i][1]) * (points[k][0] - points[i][0]);
                    int y = (points[k][1] - points[i][1]) * (points[j][0] - points[i][0]);
                    if (x == y) {
                        // If the slopes are equal, point k is on the same line as point i and point j
                        temp++;
                    }
                }
                // Update the maximum number of points on a line if necessary
                if (temp > ans) {
                    ans = temp;
                }
            }
        }
        // Return the maximum number of points on a line
        return ans;
    }
    
    //this is faster O(n^2)
    public int maxPoint(int[][] points) {
        int n = points.length;
        if(n <= 2) return n; // 2 or less points can always form a line.
        int ans = 2;
        
        for(int[] a : points){
            //Map<Double, Integer> for storing (slope, no of times 2 points generate this slope.)
            Map<Double, Integer> map = new HashMap<>();
            for(int[] b : points){
                if(a == b) continue; // dont measure slope for same points in plane.   
                // if a is (x1, y1) and b is(x2, y2) then slope is (y2 - y1)/(x2 -x1)
                // a (a0, a1) & b is (b0, b1)
                double slope = 0;
                if(b[0] - a[0] == 0) slope = Double.POSITIVE_INFINITY;
                else slope = (b[1] -a[1]) / (double)(b[0] - a[0]);
                //map.getOrDefault(slope, 0)+1 is adding 1 more point count for that slope if we already had that slope. 
                // by default , 1 will be count of a new slope.
                map.put(slope, map.getOrDefault(slope, 1)+1);
                ans = Math.max(ans, map.get(slope));             
            }
        } 
        //ans itself represnets max no of points forms a line 
        return ans;
    }


}
