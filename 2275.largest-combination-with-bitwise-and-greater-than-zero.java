/*
 * @lc app=leetcode id=2275 lang=java
 *
 * [2275] Largest Combination With Bitwise AND Greater Than Zero
 */

// @lc code=start
class Solution
{
    public int largestCombination(int[] candidates)
    {
        int[] bitCount = new int[24];
        for(int num : candidates)
        {
            for(int bit = 0; bit < 24; bit++)
            {
                if((num & (1 << bit)) != 0)
                {
                    bitCount[bit]++;
                }
            }
        }       

        int maxBitCount = 0;
        for(int bit : bitCount)
        {
            maxBitCount = Math.max(maxBitCount, bit);
        }

        return maxBitCount;
    }
}
// @lc code=end

