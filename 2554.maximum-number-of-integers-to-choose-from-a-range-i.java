/*
 * @lc app=leetcode id=2554 lang=java
 *
 * [2554] Maximum Number of Integers to Choose From a Range I
 */

// @lc code=start
class Solution
{
    public int maxCount(int[] banned, int n, int maxSum)
    {
        // Step 1: Create a boolean array to mark banned numbers
        boolean[] map = new boolean[10001];
        for (int i = 0; i < banned.length; i++)
        {
            map[banned[i]] = true; // Mark the banned numbers as true
        }

        // Step 2: Initialize variables for sum and count
        int sum = 0;    // To store the current sum of selected numbers
        int count = 0;  // To count the number of integers added

        // Step 3: Iterate over numbers from 1 to n
        for (int i = 1; i <= n; i++)
        {
            // Step 4: Check if adding this number exceeds maxSum
            if (sum + i > maxSum)
            {
                break; // Stop further iteration if sum exceeds maxSum
            }

            // Step 5: Include the number if it's not banned
            if (!map[i])
            {
                sum += i;   // Add the current number to the sum
                count++;   // Increment the count of selected numbers
            }
        }

        // Step 6: Return the total count of selected numbers
        return count;
    }
}
// @lc code=end

