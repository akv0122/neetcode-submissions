class Solution {
    public boolean validTree(int n, int[][] edges) {
        // valid tree must have n-1 edges
        if (edges.length != n - 1)
            return false;

        // build adjacency List
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // get u and v
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u); // adj list building step
        }

        boolean[] visited = new boolean[n];

        // dfs cycle detection
        if (!dfs(0, -1, adj, visited)) {
            return false;
        }

        // check connectivity
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }

        return true;
    }

    private boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true; // marking the node true

        // visiting neigbours
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                if (!dfs(neighbour, node, adj, visited))
                    return false;
            } else if (neighbour != parent) // visited neighbour that isnt parent means cycle exist
                return false; // cycle exist
        }

        return true;
    }
}