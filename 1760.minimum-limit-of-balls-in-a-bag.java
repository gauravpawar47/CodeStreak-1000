/*
 * @lc app=leetcode id=1760 lang=java
 *
 * [1760] Minimum Limit of Balls in a Bag
 */

// @lc code=start
import java.util.Arrays;

class Solution
{
    public int minimumSize(int[] nums, int maxOperations)
    {
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Define binary search range
        int low = 1; // Minimum possible maxBalls
        int high = nums[nums.length - 1]; // Maximum number of balls in the largest bag

        int result = high;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            // Step 3: Feasibility check
            if (canDistribute(nums, maxOperations, mid))
            {
                result = mid; // Update result with feasible maxBalls
                high = mid - 1; // Try smaller maximum
            }
            else
            {
                low = mid + 1; // Try larger maximum
            }
        }

        return result;
    }

    private boolean canDistribute(int[] nums, int maxOperations, int maxBalls)
    {
        int operations = 0;

        // Step 4: Traverse sorted array in reverse (largest to smallest)
        for (int i = nums.length - 1; i >= 0; i--)
        {
            if (nums[i] <= maxBalls)
            {
                break;
            } 

            // Calculate required splits for larger bags
            operations += (nums[i] - 1) / maxBalls;
            if (operations > maxOperations)
            {
                return false;
            } 
        }

        return true;
    }
}
// @lc code=end

