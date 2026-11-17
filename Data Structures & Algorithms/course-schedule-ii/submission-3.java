class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] recursionPath = new boolean[numCourses];
        int[] result = new int[numCourses]; 

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (isCycleDfs(i, prerequisites, visited, recursionPath))
                    return new int[0];
            }
        }

        // topo sorting
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(visited, false);

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                topologicalSorting(i, prerequisites, visited, stack);
            }
        }

        int index = 0;
        while (!stack.isEmpty()) {
            int val = stack.pop();
            result[index] = val;
            index++;
        }

        return result;
    }

    void topologicalSorting(
        int course, int[][] prerequisites, boolean[] visited, Stack<Integer> stack) {
        visited[course] = true;
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];

            if (course == u) {
                if (!visited[v]) {
                    topologicalSorting(v, prerequisites, visited, stack);
                }
            }
        }

        stack.push(course);
    }

    private boolean isCycleDfs(
        int course, int[][] prerequisites, boolean[] visited, boolean[] recursionPath) {
        visited[course] = true;
        recursionPath[course] = true;

        // find u and v first

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];

            if (course == u) {
                if (!visited[v]) {
                    if (isCycleDfs(v, prerequisites, visited, recursionPath))
                        return true;
                } else if (recursionPath[v]) { // backEdgeCondition
                    // means cycle exist
                    // System.out.println("cycle Exist");
                    return true;
                }
            }
        }

        recursionPath[course] = false;
        return false;
    }
}
