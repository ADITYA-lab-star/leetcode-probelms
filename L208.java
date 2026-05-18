public class L208 {
    class Trie {
        Trie[] children;
        boolean eow;

        public Trie() {
            children[26] = new Trie();
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;
        }

        Trie root = new Trie();

        public void insert(String word) {
            int n = word.length();
            Trie curr = root;
            for (int i = 0; i < n; i++) {
                int idx = word.charAt(i) - 'a';

                if (curr.children[idx] == null) {
                    curr.children[idx] = new Trie();
                }
                if (i == n - 1) {
                    curr.children[idx].eow = true;
                }
                curr = curr.children[idx];
            }
        }

        public boolean search(String word) {
            int n = word.length();
            Trie curr = root;
            for (int i = 0; i < n; i++) {
                int idx = word.charAt(i) - 'a';

                if ((curr.children[idx] == null) || ((i == n - 1) && (curr.children[idx].eow = false))) {
                    return false;
                }
                curr = curr.children[idx];
            }
            return true;
        }

        public boolean startsWith(String prefix) {
            int n = prefix.length();
            Trie curr = root;
            for (int i = 0; i < n; i++) {
                int idx = prefix.charAt(i) - 'a';

                if (curr.children[idx] == null) {
                    return false;
                }
                curr = curr.children[idx];
            }
            return true;
        }
    }

}
