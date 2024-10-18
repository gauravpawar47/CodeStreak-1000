/*
 * @lc app=leetcode id=2044 lang=java
 *
 * [2044] Count Number of Maximum Bitwise-OR Subsets
 */

// @lc code=start
class Solution
{
    public void backtrack(int []nums, int index, int currentOR, int maxOR, int[] count)
    {
        if(currentOR == maxOR)
        {
            count[0]++;
        }

        for(int i = index; i < nums.length; i++)
        {
            backtrack(nums, i + 1, currentOR | nums[i], maxOR, count);
        }
    }

    public int countMaxOrSubsets(int[] nums)
    {
        int maxOR = 0;

        // Step 1 : Calculate the Maximum OR
        for(int num : nums)
        {
            maxOR = maxOR | num;
        }

        int[] count = new int[1];
        // Step 2 : Backtrack to Count the Subsets
        backtrack(nums, 0, 0, maxOR, count);
    
        return count[0];
    }
}
// @lc code=end

