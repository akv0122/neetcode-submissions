class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] recPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (isCycleDfs(i, prerequisites, visited, recPath))
                    return false; // cycle detected
            }
        }

        return true;
    }

    public boolean isCycleDfs(
        int course, int[][] prerequisites, boolean[] visited, boolean[] recPath) {
        visited[course] = true;
        recPath[course] = true;

        for (int i = 0; i < prerequisites.length; i++) {
            // edge is from u-->v
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];

            if (u == course) { // if u is the source node then v is the neighbour.
                if (!visited[v]) { // so we are applying dfs for neighbour

                    if (isCycleDfs(v, prerequisites, visited, recPath))
                        return true; // cycle detected while recurively calling neighbours
                } else if (recPath[v])
                    return true; // means cycle detected
            }
        }

        recPath[course] = false; // need to remove the entry from the recPath

        return false;
    }
}
