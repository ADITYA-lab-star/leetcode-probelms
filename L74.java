public class L74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int k = m * n;

        int front = 0;
        int back = k - 1;

        while (front <= back) {
            int mid = front + (back - front) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                back = mid - 1;
            } else {
                front = mid + 1;
            }
        }
        return false;
    }
}
