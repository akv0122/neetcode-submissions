class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] colsArray = new boolean[n];
        boolean[] diagonalArray1 = new boolean[2 * n];
        boolean[] diagonalArray2 = new boolean[2 * n];

        helper(0, board, results, colsArray, diagonalArray1, diagonalArray2, n);

        return results;
    }

    private void helper(int row, char[][] board, List<List<String>> results, boolean[] colsArray,
        boolean[] diagonalArray1, boolean[] diagonalArray2, int n) {
        // base case
        if (row == n) {
            List<String> solution = new ArrayList<>();

            for (char[] ch : board) {
                solution.add(new String(ch));
            }

            results.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n;
            int d2 = row + col;

            // check whether the postions are safe

            if (colsArray[col] || diagonalArray1[d1] || diagonalArray2[d2]) {
                continue;
            }

            // place queen
            board[row][col] = 'Q';

            colsArray[col] = true;
            diagonalArray1[d1] = true;
            diagonalArray2[d2] = true;

            // recursoin call to move to next row
            helper(row + 1, board, results, colsArray, diagonalArray1, diagonalArray2, n);

            // backtracking
            board[row][col] = '.';

            colsArray[col] = false;
            diagonalArray1[d1] = false;
            diagonalArray2[d2] = false;
        }
    }
}
