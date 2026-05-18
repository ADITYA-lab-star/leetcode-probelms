public class L1021 {

    // slow 10ms
    public String removeOuterParentheses(String s) {
        int n = s.length();
        String res = "";
        int c = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                c++;
                if (c == 1) {
                    continue;
                }
            } else if (ch == ')') {
                c--;
                if (c == 0) {
                    continue;
                }
            }
            res += ch;
        }
        return res;
    }

    // using string builder makes it faster 2ms
    public String removeOuterParenthese(String s) {
        StringBuilder res = new StringBuilder();
        int l = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (l > 0)
                    res.append(ch);
                l++;
            } else if (ch == ')') {
                l--;
                if (l > 0)
                    res.append(ch);
            }
        }
        return res.toString();

    }
}
