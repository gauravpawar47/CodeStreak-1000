/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution
{
    public int findTargetSumWays(int[] nums, int target)
    {
        return backtrack(nums, target, 0, 0);    
    }

    public int backtrack(int[] nums, int target, int index, int currentSum)
    {
        // Step 1 : Base-Case
        if(index == nums.length)
        {
            return currentSum == target ? 1 : 0;
        }

        // Step 2 : Kaam & Inner Function Call
        int add = backtrack(nums, target, index + 1, currentSum + nums[index]);
        int sub = backtrack(nums, target, index + 1, currentSum - nums[index]);

        // Step 3 : Return the Total Ways
        return add + sub;
    }
}
// @lc code=end

