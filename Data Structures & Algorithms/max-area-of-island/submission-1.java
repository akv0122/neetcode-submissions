class Solution {

    public int dfs(int[][] grid, int i, int j){


        int rows = grid.length; 
        int cols = grid[0].length; 

        //boundry cases
        if( i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == 0) return 0;

        //marking the current node visited
        grid[i][j] = 0; //marking it as water as well

        //count current cell + connected land cells
        int area = 1; 


        //dfs call for 4 directions
        area += dfs(grid, i+1, j); 
        area += dfs(grid, i-1, j); 
        area += dfs(grid, i, j+1); 
        area += dfs(grid, i, j-1); 

        return area; 
    }


    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0; 

        for(int i = 0; i < grid.length; i++){
            for( int j =0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);  
                }
            }
        }

        return maxArea; 
        
    }
}
