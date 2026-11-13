class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int INF = Integer.MAX_VALUE;

        // add all the treasure chest to the queue.

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        // four possible directions
        int[][] directions = {
            {1, 0}, // down
            {-1, 0}, // up
            {0, 1}, // right
            {0, -1} // left
        };

        // BFS search
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // boundary check
                if (newRow < 0 || newCol < 0 || newRow >= rows || newCol >= cols)
                    continue;

                // only visit unvisited land cells
                if (grid[newRow][newCol] == INF) {
                    grid[newRow][newCol] = grid[row][col] + 1;
                    queue.offer(new int[] {newRow, newCol});
                }
            }
        }
    }
}
