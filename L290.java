import java.util.HashMap;
import java.util.Map;

public class L290 {

    //the important point is that we need to amp on both sides
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;

        Map<Character, String> p2w = new HashMap<>();
        Map<String, Character> w2p = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            String w = words[i];

            if (p2w.containsKey(p)) {
                if (!p2w.get(p).equals(w))
                    return false;
            } else {
                p2w.put(p, w);
            }

            if (w2p.containsKey(w)) {
                if (w2p.get(w) != p)
                    return false;
            } else {
                w2p.put(w, p);
            }
        }
        return true;
    }

}