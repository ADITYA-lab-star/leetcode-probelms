public class L11 {

    //brute force approach
    public int maxArea(int[] height) {
        int max = 0;
        int m = height.length;
        int w = 0;
        int temp = 0;

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                w = j - i;
                temp = (height[i] >= height[j] ? height[j] : height[i]) * w;
                if (max < temp) {
                    max = temp;
                }
            }
        }
        return max;

    }
    
    //two pointer
    public int maxArea2(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;        
    }
}
