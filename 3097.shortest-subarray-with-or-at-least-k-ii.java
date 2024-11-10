/*
 * @lc app=leetcode id=3097 lang=java
 *
 * [3097] Shortest Subarray With OR at Least K II
 */

// @lc code=start
class Solution
{
    public int minimumSubarrayLength(int[] nums, int k)
    {
        int n = nums.length;
        int[] bitCount = new int[32];
        int currentOr = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;

        for(int right = 0; right < n; right++)
        {
            currentOr |= nums[right];
            for(int bit = 0; bit < 32; bit++)
            {
                if((nums[right] & (1 << bit)) != 0)
                {
                    bitCount[bit]++;
                }
            }

            while(left <= right && currentOr >= k)
            {
                minLength = Math.min(minLength, right - left + 1);

                int updatedOr = 0;
                for(int bit = 0; bit < 32; bit++)
                {
                    if((nums[left] & (1 << bit)) != 0)
                    {
                        bitCount[bit]--;
                    }

                    if(bitCount[bit] > 0)
                    {
                        updatedOr |= (1 << bit);
                    }
                }

                currentOr = updatedOr;
                left++;
            }
        }   

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
// @lc code=end

