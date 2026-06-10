public class L151 {

    public String reverseWords(String s) {
        int n = s.length();
        int j = n - 1;
        StringBuilder bro = new StringBuilder();

        while (j >= 0) {
            // skip trailing spaces
            while (j >= 0 && s.charAt(j) == ' ')
                j--;

            if (j < 0)
                break;

            int end = j;

            // move j left until space or start
            while (j >= 0 && s.charAt(j) != ' ')
                j--;

            // extract the word
            if (bro.length() > 0)
                bro.append(" ");
            bro.append(s.substring(j + 1, end + 1));
        }

        return bro.toString();
    }

    //see this also
    public String reverseWord(String s) {
        String[] words = s.split("\\s+");
        StringBuilder res = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            res.append(words[i]);
            if (i != 0) {
                res.append(" ");
            }
        }

        return res.toString().trim();
    }
}