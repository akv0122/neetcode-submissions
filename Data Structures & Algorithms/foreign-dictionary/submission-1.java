class Solution {
    public String foreignDictionary(String[] words) {
        int[] indegree = new int[26]; //using kahns algorithm

        // building adjacency List
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        // track character present in the dictionary
        boolean[] exists = new boolean[26];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                exists[c - 'a'] = true;
            }
        }

        // build directed graph

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];

            int length = Math.min(first.length(), second.length());

            boolean foundDiff = false;

            for (int j = 0; j < length; j++) {
                int u = first.charAt(j) - 'a';
                int v = second.charAt(j) - 'a';

                if (u != v) {
                    adj.get(u).add(v);
                    indegree[v]++;

                    foundDiff = true;
                    break;
                }
            }

            // invalid prefix case
            if (!foundDiff && first.length() > second.length()) {
                return "";
            }
        }

        // adding all zero indegree charcters to queue
        Queue<Integer> q = new LinkedList<>();

        int totalCharacters = 0;

        for (int i = 0; i < 26; i++) {
            if (exists[i]) {
                totalCharacters++;

                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        // applying kahns Algo
        StringBuilder result = new StringBuilder();

        while (!q.isEmpty()) {
            int current = q.poll();

            result.append((char)('a' + current)); // converint ascii to char

            // checking neighbours
            for (int neighbour : adj.get(current)) {
                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    q.offer(neighbour);
                }
            }
        }

        // cycle detection
        if (result.length() != totalCharacters)
            return "";

        return result.toString();
    }
}
