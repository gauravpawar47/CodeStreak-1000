/*
 * @lc app=leetcode id=773 lang=java
 *
 * [773] Sliding Puzzle
 */

// @lc code=start
import java.util.*;

class Solution
{
    public int slidingPuzzle(int[][] board)
    {
        // Step 1 : Conver the Board into a String Representation
        StringBuilder start = new StringBuilder();
        for(int[] row : board)
        {
            for(int num : row)
            {
                start.append(num);
            }
        }

        String target = "123450"; // To Solved State

        // Step 2 : Directions for '0's Possible movements in 2 X 3 Matrix
        int[][] neighbors = {
            {1, 3},         // 0 : Top Left Corner
            {0, 2, 4},      // 1 : Top Middle 
            {1, 5},         // 2 : Top Right Corner
            {0, 4},         // 3 : Bottom Left Corner
            {1, 3, 5},      // 4 : Bottom Middle
            {2, 4}          // 5 : Bottom Right Corner
        };

        // Step 3 : BFS Setup
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start.toString());
        visited.add(start.toString());

        int moves = 0;

        // Step 4 : BFS Traversal
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                String state = queue.poll();

                // Step 5 : Check If We've Reached the Target State
                if(state.equals(target))
                {
                    return moves;
                }

                // Step 6 : Find the Index of '0'
                int zeroIdx = state.indexOf('0');

                // Step 7 : Exploring Neighbors
                for(int neighbor : neighbors[zeroIdx])
                {
                    char[] newState = state.toCharArray(); // Swap '0' with Neighbor
                    newState[zeroIdx] = newState[neighbor];
                    newState[neighbor] = '0';

                    String newStateString = new String(newState);

                    if(!visited.contains(newStateString))
                    {
                        visited.add(newStateString);
                        queue.offer(newStateString);
                    }
                }
            }

            moves++;
        }

        return -1; // If No Solution is Found
    }
}
// @lc code=end

