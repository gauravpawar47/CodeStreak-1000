/*
 * @lc app=leetcode id=2924 lang=java
 *
 * [2924] Find Champion II
 */

// @lc code=start
class Solution
{
    public int findChampion(int n, int[][] edges)
    {
        // Step 1 : Declare Auxilary Array To Store Indegree
        int[] indegree = new int[n];
        int champion = -1;

        // Step 2 : Count the Indegree from Edges
        for(int[] edge : edges)
        {
            indegree[edge[1]]++;
        }

        // Step 3 : Find the Champion
        for(int i = 0; i < indegree.length; i++)
        {
            if(indegree[i] == 0)
            {
                if(champion != -1) // Check if Duplicate Entry is Found
                {
                    return -1;   
                }
                champion = i;
            }
        }

        return champion;
    }
}
// @lc code=end

