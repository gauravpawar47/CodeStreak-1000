/*
 * @lc app=leetcode id=2938 lang=java
 *
 * [2938] Separate Black and White Balls
 */

// @lc code=start
class Solution
{
    public long minimumSteps(String s)
    {
        long count = 0;
        long steps = 0;
        for(int i = s.length() - 1; i >= 0; i--)
        {
            if(s.charAt(i) == '0')
            {
                count++;
            }
            else
            {
                steps += count;
            }
        }    
        return steps;
    }
}
// @lc code=end

