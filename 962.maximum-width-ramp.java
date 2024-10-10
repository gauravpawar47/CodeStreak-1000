/*
 * @lc app=leetcode id=962 lang=java
 *
 * [962] Maximum Width Ramp
 */

// @lc code=start
class Solution
{
    public int maxWidthRamp(int[] nums)
    {
        int n = nums.length;
        int[] leftMin = new int[n];        
        
        leftMin[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }

        int maxWidth = 0;
        int j = n - 1;

        for(int i = n - 1; i >= 0; i--)
        {
            while(j >= 0 && nums[i] >= leftMin[j])
            {
                maxWidth = Math.max(maxWidth, i - j);
                j--;
            }
        }

        return maxWidth;
    }
}
// @lc code=end

