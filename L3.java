import java.util.HashSet;

public class L3 {

    public int lengthOfLongestSubstring(String s) {
        int arr[] = new int[95];
        int front = 0;
        int back = 0;
        int k = 0;
        int len = s.length();
        while (front != len) {
            char ch = s.charAt(front);
            int c = ch - ' ';
            if (arr[c] != 1) {
                k = front - back;
                arr[c] = 1;
            } else {
                while (ch != s.charAt(back)) {
                    back++;
                }
                back++;
            }
            front++;

        }
        if (s.isEmpty()) {
            return k;
        }
        return k + 1;
    }
    
    //  THERE IS a little error in the above code
    public int lengthOfLongestSubstring2(String s) {
        int left = 0;
        int maxLength = 0;
        HashSet<Character> charSet = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }

            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;       
    }
}
