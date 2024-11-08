/*
 * @lc app=leetcode id=1829 lang=java
 *
 * [1829] Maximum XOR for Each Query
 */

// @lc code=start
class Solution
{
    public int[] getMaximumXor(int[] nums, int maximumBit)
    {
        int[] ans = new int[nums.length];
        int xorValue = 0;

        // Calculate the cumulative XOR of all elements in nums
        for (int num : nums)
        {
            xorValue ^= num;
        }

        // Define the maximum XOR possible with maximumBit
        int maxVal = (1 << maximumBit) - 1;

        // Fill ans by applying the XOR with maxVal and removing elements in reverse
        for (int i = 0; i < nums.length; i++)
        {
            ans[i] = xorValue ^ maxVal;    // Maximize XOR with maxVal
            xorValue ^= nums[nums.length - 1 - i];  // Adjust xorValue by removing from end
        }
        return ans;
    }
}
// @lc code=end

