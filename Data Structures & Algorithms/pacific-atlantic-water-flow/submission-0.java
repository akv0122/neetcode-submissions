class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        if (heights == null || heights.length == 0 || heights[0].length == 0)
            return result;

        int row = heights.length;
        int col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        // dfs logic
        // for cols
        for (int i = 0; i < col; i++) {
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific);
            dfs(heights, row - 1, i, Integer.MIN_VALUE, atlantic);
        }
        // for rows
        for (int i = 0; i < row; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, col - 1, Integer.MIN_VALUE, atlantic);
        }

        // writing the result list
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i, j));
            }
        }

        return result;
    }

    public void dfs(int[][] heights, int row, int col, int prev, boolean[][] ocean) {
        if (row < 0 || row >= ocean.length || col < 0 || col >= ocean[0].length)
            return;

        if (prev > heights[row][col] || ocean[row][col])
            return; // water can't flow and visited check

        ocean[row][col] = true;
        // making all dfs calls
        for (int[] dir : directions) {
            dfs(heights, row + dir[0], col + dir[1], heights[row][col], ocean);
        }
    }
}
