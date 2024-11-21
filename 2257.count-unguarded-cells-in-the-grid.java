/*
 * @lc app=leetcode id=2257 lang=java
 *
 * [2257] Count Unguarded Cells in the Grid
 */

// @lc code=start
class Solution
{
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls)
    {
        char[][] grid = new char[m][n];

        // Step 1 : Mark All Guards and Walls
        for(int[] guard : guards)
        {
            grid[guard[0]][guard[1]] = 'G';
        }
    
        for(int[] wall : walls)
        {
            grid[wall[0]][wall[1]] = 'W';
        }

        // Step 2 : Directions for Traversal : Up, Down, Left, Right
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Step 3 : Mark Guarded Cells
        for(int[] guard : guards)
        {
            for(int[] dir : dirs)
            {
                int x = guard[0];
                int y = guard[1];

                while(true)
                {
                    x += dir[0];
                    y += dir[1];

                    if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 'G' || grid[x][y] == 'W')
                    {
                        break;
                    } 

                    // Step 4 : Mark As Guarded
                    if(grid[x][y] == 0)
                    {
                        grid[x][y] = 'X';
                    }
                }
            }
        }

        // Step 5 : Count Ungaurded Cells
        int ugCells = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 0)
                {
                    ugCells += 1;
                }
            }
        }

        return ugCells;
    }
}
// @lc code=end

