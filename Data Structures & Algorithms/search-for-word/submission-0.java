class Solution {
    // private final List<String> result = new ArrayList<>();

    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int wordIdx) {
        // base case
        if (wordIdx == word.length()) {
            return true;
        }

        // out of bound cases
        if (c < 0 || c >= board[0].length || r < 0 || r >= board.length) {
            return false;
        }

        // invalid cases
        if (board[r][c] == '#' || board[r][c] != word.charAt(wordIdx))
            return false;

        // keeping backup
        char ch = board[r][c];

        board[r][c] = '#';

        // dfs calls
        if (dfs(board, word, r + 1, c, wordIdx + 1) || dfs(board, word, r - 1, c, wordIdx + 1)
            || dfs(board, word, r, c + 1, wordIdx + 1) || dfs(board, word, r, c - 1, wordIdx + 1)) {
            board[r][c] = ch;
            return true;
        }

        // backtracking
        board[r][c] = ch;

        return false;
    }
}
