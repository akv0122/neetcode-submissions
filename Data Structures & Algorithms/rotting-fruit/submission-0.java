class Solution {
    public int orangesRotting(int[][] grid) {
        int freshOrange = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshOrange++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        if (freshOrange == 0)
            return 0;

        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) { // level by level
                int[] rottenLoc = queue.poll();
                int r = rottenLoc[0]; // row of the rotten orange
                int c = rottenLoc[1]; // col of the rotten orange
                // neighbors in all 4 directions
                int[][] neighbors = {{r + 1, c}, {r - 1, c}, {r, c + 1}, {r, c - 1}};

                // visting each neighbor
                for (int[] neighbor : neighbors) {
                    int nr = neighbor[0];
                    int nc = neighbor[1];
                    // check boundary, rotten orange and visited
                    if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length
                        || grid[nr][nc] == 2 || grid[nr][nc] != 1)
                        continue;

                    queue.offer(new int[] {nr, nc});
                    // marking visited
                    grid[nr][nc] = 2;
                    freshOrange--;
                    if (freshOrange == 0)
                        return time + 1;
                }
            }

            time++;
        }

        return -1;
    }
}
