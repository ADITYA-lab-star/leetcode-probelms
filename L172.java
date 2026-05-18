public class L172 {
    public int trailingZeroes(int n) {
        int c = 0;
        int z = 0;
        while ((int) Math.pow(5, c) <= n) {
            c++;
            z += n / (int) Math.pow(5, c);
        }
        return z;
    }
}
