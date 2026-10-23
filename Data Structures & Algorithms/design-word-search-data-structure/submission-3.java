class WordDictionary {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        Boolean eow;

        public TrieNode() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }

            eow = false;
        }
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.eow = true;
    }

    private boolean helper(TrieNode node, String word, int index) {
        if (node == null)
            return false;

        if (index == word.length())
            return node.eow; 

        char c = word.charAt(index);

        if (c != '.') {
            if (node.children[c - 'a'] == null)
                return false;
            return helper(node.children[c - 'a'], word, index + 1);

        } else {
            for (int i = 0; i < 26; i++) {
                if (helper(node.children[i], word, index + 1)) {
                    return true;
                }
            }

            return false;
        }
    }

    public boolean search(String word) {
        TrieNode node = root;

        return helper(root, word, 0);
    }
}
