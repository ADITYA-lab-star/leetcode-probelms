public class L201 {
    //this is very slow
    public int rangeBitwiseAnd(int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            left = left & i;
        }
        return left;
    }

    //this very fast
    public int rangeBitwiseAn(int left, int right) {
        int cnt = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            cnt++;
        }
        return (left << cnt);
    }

}
