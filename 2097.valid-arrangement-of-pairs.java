/*
 * @lc app=leetcode id=2097 lang=java
 *
 * [2097] Valid Arrangement of Pairs
 */

// @lc code=start
import java.util.*;

class Solution
{
    public int[][] validArrangement(int[][] pairs)
    {
        int n = pairs.length;
        
        // Step 1: Initialize the answer array to store the valid arrangement
        int[][] ans = new int[n][2];
        for (int[] a : ans)
        {
            a[0] = -1;  // Default value for start of the pair
            a[1] = -1;  // Default value for end of the pair
        }
        
        // Step 2: Create maps for outdegree and adjacency list (outgoing edges)
        Map<Integer, Integer> outdegree = new HashMap<>();
        Map<Integer, Deque<Integer>> out = new HashMap<>();
        
        // Step 3: Populate the outdegree map and the adjacency list for outgoing edges
        for (int[] pair : pairs)
        {
            // Increase outdegree for starting node and decrease for the ending node
            outdegree.put(pair[0], outdegree.getOrDefault(pair[0], 0) + 1);
            outdegree.put(pair[1], outdegree.getOrDefault(pair[1], 0) - 1);
            
            // Create adjacency list for both start and end nodes
            out.computeIfAbsent(pair[0], k -> new ArrayDeque<>());
            out.computeIfAbsent(pair[1], k -> new ArrayDeque<>());
            
            // Add destination node to the list of outgoing edges for the starting node
            out.get(pair[0]).addLast(pair[1]);
        }
        
        // Step 4: Find the start and end nodes for the Eulerian path
        for (Map.Entry<Integer, Integer> entry : outdegree.entrySet())
        {
            if (entry.getValue() == 1)
            {
                ans[0][0] = entry.getKey(); // Start node has outdegree > indegree
            }
            if (entry.getValue() == -1)
            {
                ans[n - 1][1] = entry.getKey(); // End node has indegree > outdegree
            }
        }
        
        // Step 5: Handle the case where no specific start and end node was identified
        if (ans[0][0] == -1)
        {
            ans[0][0] = pairs[0][0]; // Default to the first pair's start node
            ans[n - 1][1] = pairs[0][0]; // Default end node is the same as start
        }
        
        // Step 6: Use a two-pointer approach to build the valid arrangement
        int i = 0; // Pointer for the start of the array
        int j = n - 1; // Pointer for the end of the array
        
        while (i < j)
        {
            // Step 7: Find the outgoing node for the current start node
            int from = ans[i][0];
            
            // Step 8: Get the adjacency list (outgoing edges) for the current node
            Deque<Integer> toList = out.get(from);
            
            // Step 9: If no outgoing edges remain, backtrack and move the pointers
            if (toList.size() == 0)
            {
                ans[j][0] = ans[--i][0]; // Move start pointer backward
                ans[--j][1] = ans[j + 1][0]; // Move end pointer backward
            }
            else
            {
                // Step 10: If there are outgoing edges, continue building the path
                ans[i++][1] = toList.removeLast(); // Remove last element from the adjacency list
                ans[i][0] = ans[i - 1][1]; // Update the current start node to the last pair's end node
            }
        }
        
        // Step 11: Return the final valid arrangement of pairs
        return ans;
    }
}
// @lc code=end

