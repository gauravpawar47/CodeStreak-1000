/*
 * @lc app=leetcode id=2684 lang=java
 *
 * [2684] Maximum Number of Moves in a Grid
 */

// @lc code=start
class Solution
{
    public int rows;
    public int cols;
    public int[][] grid;
    public int[][] dp;

    public int maxMoves(int[][] grid)
    {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.grid = grid;
        this.dp = new int[rows][cols];
        int maxMove = 0;

        for(int i = 0; i < rows; i++)
        {
            maxMove = Math.max(maxMove, dfs(i, 0));
        }
        
        return maxMove;
    }

    public int dfs(int i, int j)
    {
        if(j == cols - 1)
        {
            return 0;
        }

        if(dp[i][j] != 0)
        {
            return dp[i][j]; 
        }

        int maxPath = 0;
        int currentValue = grid[i][j];    
        int [][]directions = {{-1, 1}, {0, 1}, {1, 1}};
    
        for(int[] direction : directions)
        {
            int newRow = i + direction[0];
            int newColn = j + direction[1];
    
            if(newRow >= 0 && newRow < rows && newColn < cols && grid[newRow][newColn] > currentValue)
            {
                maxPath = Math.max(maxPath, 1 + dfs(newRow, newColn));
            }
        }

        dp[i][j] = maxPath;
        return maxPath;
    }
}
// @lc code=end

