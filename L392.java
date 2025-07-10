public class L392 {
    //time limit exceeded with recursion
    private boolean isSub(String s, String t,String temp,int i) {
        if (i<t.length()) {
            char ch = t.charAt(i);
            return isSub(s, t, temp + ch, i + 1)||isSub(s, t, temp, i+1);
        }
        else{
            return s.equals(temp);
        }
    }    

    public boolean isSubsequence(String s, String t) {
        return isSub(s, t, "", 0);
    }
     
    //easy using two pointer
    public boolean isSubseq(String s, String t) {
        int sp = 0;
        int tp = 0;

        while (sp < s.length() && tp < t.length()) {
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
            }
            tp++;
        }

        return sp == s.length();        
    }
} 
