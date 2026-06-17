public class L79 {
    public boolean exist(char[][] board, String word) {
        // Edge case: if board is empty
        if (board == null || board.length == 0) return false;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // If the first letter matches, start the DFS
                if (board[i][j] == word.charAt(0)) {
                    if (help(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean help(char[][] board, String word, int i, int j, int idx) {
        // 1. Success Base Case: We've matched all characters in the word
        if (idx == word.length()) {
            return true;
        }
        
        // 2. Failure Base Case: Out of bounds OR character doesn't match
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx)) {
            return false;
        }
        
        // 3. Mark the current cell as visited to prevent reusing it
        char temp = board[i][j];
        board[i][j] = '#'; 
        
        // 4. Explore all 4 adjacent directions
        boolean found = help(board, word, i + 1, j, idx + 1) || 
                        help(board, word, i, j + 1, idx + 1) || 
                        help(board, word, i - 1, j, idx + 1) || 
                        help(board, word, i, j - 1, idx + 1);
        
        // 5. Backtrack: Restore the cell's original character so other paths can use it
        board[i][j] = temp;
        
        return found;
    }

}
