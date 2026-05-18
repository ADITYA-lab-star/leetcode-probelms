public class L58 {

    public int lengthOfLastWord(String s) {
        int n = s.length();
        int c = 0;
        int flag = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ' && flag != 1) {
                flag = 1;
                c++;
            } else if (flag == 1) {
                if (s.charAt(i) != ' ') {
                    c++;
                }
                else {
                    return c;
                }
            }
        }
        return c;
    }
}