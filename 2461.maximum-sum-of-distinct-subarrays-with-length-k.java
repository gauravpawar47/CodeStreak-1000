/*
 * @lc app=leetcode id=2461 lang=java
 *
 * [2461] Maximum Sum of Distinct Subarrays With Length K
 */

// @lc code=start
import java.util.HashMap;

class Solution
{
    public long maximumSubarraySum(int[] nums, int k)
    {
        // Step 1 : HashMap to track occurrences of elements in the current window
        HashMap<Integer, Integer> occurrences = new HashMap<>();
        long maxSum = 0;
        long currentSum = 0;

        // Step 2 : Sliding window
        for (int i = 0; i < nums.length; i++)
        {
            // Step 3 : Add the current element to the window
            occurrences.put(nums[i], occurrences.getOrDefault(nums[i], 0) + 1);
            currentSum += nums[i];

            // Step 4 : If the window size exceeds k, remove the leftmost element
            if (i >= k)
            {
                int left = nums[i - k];
                occurrences.put(left, occurrences.get(left) - 1);
                
                if (occurrences.get(left) == 0)
                {
                    occurrences.remove(left);
                }

                currentSum -= left;
            }

            // Step 5 : Check if the current window has no duplicate elements
            if (occurrences.size() == k)
            {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}
// @lc code=end

