public class L242 {

    public boolean isAnagram(String s, String t) {
        int n = s.length();
        if (n!=t.length()) {
            return false;
        }

        int a[] = new int[26];
        
        for (int i = 0; i < n; i++) {
            int j = s.charAt(i) - 'a';
            a[j]++;
        }
        for (int i = 0; i < n; i++) {
            int j = t.charAt(i) - 'a';
            a[j]--;
        }
        for (int i = 0; i < 26; i++) {
            if (a[i] != 0) {
                return false;
            }
        }
        return true;
    }
}