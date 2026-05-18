
public class L1922 {

    long mod = 1000000007;

    public int countGoodNumbers(long n) {
        return (int) ((quickmul(5, (n + 1) / 2) * quickmul(4, n / 2)) % mod);
    }

    // use fast exponentiation to calculate x^y % mod
    public long quickmul(int x, long y) {
        long ret = 1;
        long mul = x;
        while (y > 0) {
            if (y % 2 == 1) {
                ret = (ret * mul) % mod;
            }
            mul = (mul * mul) % mod;
            y /= 2;
        }

        return ret;
    }

    class Solution {
        // faster solution
    static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenPos = (n + 1) / 2;
        long oddPos = n / 2;

        long ans = (pow(5, evenPos) * pow(4, oddPos)) % MOD;
        return (int) ans;
    }

    private long pow(long base, long exp) {
        if (exp == 0) return 1;
        long half = pow(base, exp / 2);
        long res = (half * half) % MOD;
        if (exp % 2 == 1) res = (res * base) % MOD;
        return res;
    }
}

}
