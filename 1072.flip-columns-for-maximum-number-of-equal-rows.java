/*
 * @lc app=leetcode id=1072 lang=java
 *
 * [1072] Flip Columns For Maximum Number of Equal Rows
 */

// @lc code=start
import java.util.*;

class Solution
{
    public int maxEqualRowsAfterFlips(int[][] matrix)
    {
        // Step 1 : Initialize Counters
        int cols = matrix[0].length;
        int maxRows = Integer.MIN_VALUE;

        for(int[] currentRow : matrix)
        {
            // Step 2 : Create a Array to Store the Flipped Version of Current Row
            int[] flippedRow = new int[cols];
            for(int col = 0; col < cols; col++)
            {
                flippedRow[col] = 1 - currentRow[col];
            }

            // Step 3 : Create Every Row Against Current Row and Its Flipped Version
            int identical = 0;
            for(int[] compareRow : matrix)
            {
                // Step 4 : If Row Matches Original or Flipped Pattern, Increment Counter
                if(Arrays.equals(flippedRow, compareRow) || Arrays.equals(currentRow, compareRow))
                {
                    identical += 1;
                }
            }

            // Step 5 : Count Max Rows
            maxRows = Math.max(maxRows, identical);
        }    

        return maxRows;
    }
}
// @lc code=end

