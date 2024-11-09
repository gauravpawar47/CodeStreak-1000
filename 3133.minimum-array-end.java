/*
 * @lc app=leetcode id=3133 lang=java
 *
 * [3133] Minimum Array End
 */

// @lc code=start
class Solution
{
    public long minEnd(int n, int x)
    {
        long result = x;
        long remainder = n - 1;
        long position = 1;

        while(remainder != 0)
        {
            if((x & position) == 0)
            {
                result |= (remainder & 1) * position;
                remainder >>= 1;
            }
            position <<= 1;
        }    

        return result;
    }
}
// @lc code=end

