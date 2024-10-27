/*
 * @lc app=leetcode id=1277 lang=java
 *
 * [1277] Count Square Submatrices with All Ones
 */

// @lc code=start
import java.util.Arrays;

class Solution
{
    public int solve(int i, int j, int[][] matrix, int[][] dp)
    {
        // Step 3 : Check if Cell Lies Outside Grid, return 0
        if(i >= matrix.length || j >= matrix[0].length)
        {
            return 0;
        }

        if(matrix[i][j] == 0)
        {
            return 0;
        }

        // Step 4 : If Cell is Already Visited return Memoized Value
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }

        int right = solve(i, j + 1, matrix, dp); // Step 5 : Find to Right Side 
        int diagonal = solve(i + 1, j + 1, matrix, dp); // Step 6 : Find to Diagonal
        int below = solve(i + 1, j, matrix, dp); // Step 7 : Find to Below Side

        return dp[i][j] = 1 + Math.min(right, Math.min(diagonal, below));
    }

    public int countSquares(int[][] matrix)
    {
        // Step 1 : Create DP and Fill it With Zeros
        int ans = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                Arrays.fill(dp[i], -1);
            }
        }        

        // Step 2 : Call Solve Function to count Submatrices
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                ans += solve(i, j, matrix, dp);
            }
        }

        return ans;
    }
}
// @lc code=end

