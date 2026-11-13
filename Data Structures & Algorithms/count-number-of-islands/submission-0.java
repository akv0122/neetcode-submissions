class Solution {
    public void dfs(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        // boundary check
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0')
            return;

        // mark current land as visited
        grid[i][j] = '0';

        dfs(grid, i + 1, j); // down
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j - 1); // left
    }
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int isLands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    isLands++;
                    dfs(grid, i, j);
                }
            }
        }

        return isLands;
    }
}
