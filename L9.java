public class L9 {
    //this method taking 13ms runtime
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String num = "";
        int original = x;
        while (x > 0) {
            num += Integer.toString(x % 10);
            x /= 10;
        }
        int n = num.length();
        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) != num.charAt(n - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    //this runtime 4ms
    public boolean isPalindrom(int x) {
        if (x < 0) {
            return false;
        }

        int reverse = 0;
        int xcopy = x;

        while (x > 0) {
            reverse = (reverse * 10) + (x % 10);
            x /= 10;
        }

        return reverse == xcopy;        
    }

}
