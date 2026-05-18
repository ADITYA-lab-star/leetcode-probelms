public class L796 {
    public boolean rotateString(String s, String goal) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            s += s.charAt(i);
            if (s.substring(i + 1).equals(goal)) {
                return true;
            }
        }
        return false;
    }
    //faster solution
    public boolean rotateStrin(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }
}
