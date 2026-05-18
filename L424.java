public class L424 {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxCount = 0;
        int maxlen = 0;
        int start = 0;
        int arr[] = new int[26];

        for (int end = 0; end < n; end++) {
            maxCount = maxCount > ++arr[s.charAt(end) - 'A'] ? maxCount : arr[s.charAt(end) - 'A'];

            if (end - start + 1 - maxCount > k) {
                arr[s.charAt(start++) - 'A']--;
            }

            maxlen = maxlen > (end - start + 1) ? maxlen : (end - start + 1);
        }
        return maxlen;
    }
}
