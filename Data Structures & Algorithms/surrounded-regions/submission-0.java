class Solution {
    public void solve(char[][] board) {
        // border traversal
        for (int i = 0; i < board.length; i++) { //dfs call for cols
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }

            if(board[i][board[0].length - 1] == 'O'){
                dfs(board, i, board[0].length - 1 ); 
            }
        }

        for (int i = 0; i < board[0].length; i++) { //dfs call for rows
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }

            if(board[board.length - 1][i] == 'O'){
                dfs(board, board.length-1, i); 
            }
        }

        //grid traversal and replacing values in the grid 
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if( board[i][j] == '#'){
                    board[i][j] = 'O'; 
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = '#';

        // dfs calls for all 4 directions
        for (int[] dir : directions) {
            dfs(board, i + dir[0], j + dir[1]);
        }
    }
}
