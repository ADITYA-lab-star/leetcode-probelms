public class L1358  {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int a = -1;
        int b = -1;
        int c = -1;
        int count = 0;

        
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'a':
                    a = i;
                    break;
                case 'b':
                    b = i;
                    break;
                case 'c':
                    c = i;
                    break;
                default:
                    break;
            }

            if (a >= 0 && b >= 0 && c >= 0) {
                count += Math.min(a, Math.min(b, c)) + 1;
            }

        }
        return count;
    }
}
