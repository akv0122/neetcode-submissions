class PrefixTree {
    static class Node {
        Node[] children = new Node[26];
        Boolean isEndOfWord = false;

        public Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    private final Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                current.children[index] = new Node();
            }

            if (i == word.length() - 1) {
                current.children[index].isEndOfWord = true;
            }

            current = current.children[index];
        }
    }

    public boolean search(String word) {
        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (current.children[index] == null)
                return false;

            if (i == word.length() - 1 && current.children[index].isEndOfWord == false)
                return false;

            current = current.children[index];
        }

        return true;
    }

    public boolean startsWith(String prefix) {
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';

            if (current.children[index] == null)
                return false;

            current = current.children[index];
        }

        return true;
    }
}
