class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;

        
    }

    private final TrieNode root = new TrieNode();
    private final List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        // build trie
        for (String word : words) {
            insert(word);
        }

        int rows = board.length;
        int cols = board[0].length;

        // Start dfs calls
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root); 
            }
        }

        return result; 
    }

    private void insert(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.word = word;
    }

    private void dfs(char[][] board, int r, int c, TrieNode root) {
        // outbound condtions
        if (c < 0 || r < 0 || r >= board.length || c >= board[0].length)
            return;

        char ch = board[r][c];

        // already visited or no matching triePrefix
        if (ch == '#' || root.children[ch - 'a'] == null)
            return;

        TrieNode node = root.children[ch - 'a'];

        // found a complete word
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // avoiding adding same word more than once
        }

        // mark the cell as visited
        board[r][c] = '#';

        // 4 directions
        dfs(board, r + 1, c,  node);
        dfs(board, r - 1, c,  node);
        dfs(board, r, c + 1, node);
        dfs(board, r, c - 1, node);

        // restore the original char//backtracking
        board[r][c] = ch;
    }
}
