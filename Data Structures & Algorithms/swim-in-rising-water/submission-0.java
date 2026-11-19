class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        boolean[][] visited = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(new int[] {grid[0][0], 0, 0}); // pq: {elevation, row, col}

        int max = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int height = current[0];
            int row = current[1];
            int col = current[2];

            max = Math.max(max, height);

            if (visited[row][col])
                continue;

            visited[row][col] = true;

            if (row == n - 1 && col == n - 1) {
                return max;
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n
                    && !visited[newRow][newCol]) {
                    pq.offer(new int[] {grid[newRow][newCol], newRow, newCol});
                }
            }
        }

        return -1;
    }
}
