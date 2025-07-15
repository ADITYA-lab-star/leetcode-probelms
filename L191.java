

public class L191 {
    //your solution
    public int hammingWeight(int n) {
        int count = 0;

        String binary = Integer.toBinaryString(n);
        int d = binary.length();

        for (int i = 0; i < d; i++) {
            if (binary.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
    //better solution
    public int hammingWeigh(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                res += 1;
            }
        }
        return res;        
    }

}
