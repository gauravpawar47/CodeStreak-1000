/*
 * @lc app=leetcode id=3254 lang=java
 *
 * [3254] Find the Power of K-Size Subarrays I
 */

// @lc code=start

import java.util.*;

class Solution
{
    public int[] resultsArray(int[] nums, int k)
    {
        int n = nums.length;
        ArrayList<Integer> result = new ArrayList<>();


        // Trvaerse each Subarray starting from index i
        for(int i = 0; i <= n - k; i++)
        {
            int[] subarray = Arrays.copyOfRange(nums, i, i + k);

            // Check if Subarray is Sorted and Consecutive
            if(isSortedAndConsecutive(subarray, k))
            {
                // Find the Largest Element from Subarray
                result.add(Arrays.stream(subarray).max().getAsInt());
            }
            else
            {
                result.add(-1);
            }
        }

        // Convert ArrayList to Array
        return result.stream().mapToInt(i -> i).toArray();
    }

    public boolean isSortedAndConsecutive(int[] subarray, int k)
    {
        for(int i = 1; i < k; i++)
        {
            if(subarray[i] != subarray[i - 1] + 1)
            {
                return false; // Not Sorted Or Not Consecutivie
            }
        }

        return true; // Sorted and Consecutive
    }
}
// @lc code=end

