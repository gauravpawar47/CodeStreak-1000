/*
 * @lc app=leetcode id=3243 lang=java
 *
 * [3243] Shortest Distance After Road Addition Queries I
 */

// @lc code=start
import java.util.*;

class Solution
{
    public int[] shortestDistanceAfterQueries(int n, int[][] queries)
    {
        // Step 1 : Declare HashMap to Keep The Track Of Destination and Result
        int[] result = new int[queries.length];        
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        // Step 2 : Populate HashMap by assigning List to Each Source
        for (int i = 0; i < n; i++)
        {
            graph.put(i, new ArrayList<>());
            if (i < n - 1)
            {
                graph.get(i).add(i + 1); // Initial unidirectional road
            }
        }

        // Step 3 : Process The Queries        
        int shortestDistance = n - 1; // Distance from 0 to n-1 is Linear
        for (int q = 0; q < queries.length; q++)
        {
            int src = queries[q][0];
            int dest = queries[q][1];
            
            // Step 4 : Update the new road
            graph.get(src).add(dest);
            
            // Step 5 : Recalculate the Shortest Path from 0 to n - 1
            shortestDistance = calculateShortestPath(graph, n);
            result[q] = shortestDistance;
        }
        
        return result;
    }
    
    private int calculateShortestPath(HashMap<Integer, ArrayList<Integer>> graph, int n)
    {
        // Step 1 : Declare Queue for Destination and Visited for Source
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        // Step 2 : Start BFS from city 0
        queue.add(new int[]{0, 0}); // {currentCity, distance}
        visited[0] = true;
        
        // Step 3 : Process The Queue
        while (!queue.isEmpty())
        {
            int[] current = queue.poll();
            int city = current[0]; // Source
            int distance = current[1]; // Destination
            
            // Step 4 : If we reach city n-1, return the distance
            if (city == n - 1)
            {
                return distance;
            }
            
            // Step 5 : Visit neighbors
            for (int neighbor : graph.get(city))
            {
                if (!visited[neighbor])
                {
                    visited[neighbor] = true; // Visiting The Neighbors
                    queue.add(new int[]{neighbor, distance + 1}); // Now Traversing Neighbor
                }
            }
        }
        
        return Integer.MAX_VALUE; // If no path exists
    }
}
// @lc code=end

