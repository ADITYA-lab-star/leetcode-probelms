public class L66 {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int n = digits.length;
        
        digits[n - 1] += 1;
        if (digits[n-1] > 9) {
            carry = digits[n-1] / 10;
            digits[n-1] = digits[n-1] % 10;
        }
        for (int i = n - 2; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] > 9) {
                carry = digits[i] / 10;
                digits[i] = digits[i] % 10;
            }
            else {
                carry = 0;
                break;
            }
        }

        if (carry > 0) {
            int res[] = new int[n + 1];
            res[0] = carry;
            for (int i = 1; i <= n; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        }
        return digits;
    }
}
