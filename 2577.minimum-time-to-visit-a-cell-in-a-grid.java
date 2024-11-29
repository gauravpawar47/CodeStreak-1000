/*
 * @lc app=leetcode id=2577 lang=java
 *
 * [2577] Minimum Time to Visit a Cell In a Grid
 */

// @lc code=start
import java.util.*;

class Solution
{
    private static final int[][] MOVES = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // Directions for movement (up, right, down, left)
    
    public int minimumTime(int[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;

        // Step 1: If both initial moves are blocked, return -1
        if (grid[0][1] > 1 && grid[1][0] > 1)
        {
            return -1;  // Both right and down from (0, 0) are not possible
        }

        // Step 2: Initialize the priority queue and the visited array
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);  // Min-heap based on time
        boolean[][] seen = new boolean[rows][cols];

        pq.offer(new int[]{0, 0, 0}); // Start with (0, 0) at time 0
        seen[0][0] = true;

        // Step 3: BFS-like traversal using priority queue
        while (!pq.isEmpty())
        {
            int[] curr = pq.poll(); // Get the current cell with the smallest time
            int time = curr[0];
            int row = curr[1];
            int col = curr[2];

            // Step 4: Explore all four directions
            for (int[] dir : MOVES)
            {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Step 5: Skip invalid cells (out of bounds or already visited)
                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || seen[newRow][newCol])
                {
                    continue;
                }

                // Step 6: Calculate the time to move to the next cell
                int newTime = time + 1;
                if (grid[newRow][newCol] > newTime)
                {
                    int wait = ((grid[newRow][newCol] - newTime + 1) / 2) * 2;  // Wait if necessary
                    newTime += wait;
                }

                // Step 7: If we reached the target cell, return the current time
                if (newRow == rows - 1 && newCol == cols - 1)
                {
                    return newTime;
                }

                // Step 8: Mark the cell as visited and add it to the priority queue
                seen[newRow][newCol] = true;
                pq.offer(new int[]{newTime, newRow, newCol});
            }
        }

        // Step 9: If no path is found, return -1
        return -1;
    }
}
// @lc code=end

