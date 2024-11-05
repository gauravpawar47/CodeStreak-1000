/*
 * @lc app=leetcode id=2914 lang=java
 *
 * [2914] Minimum Number of Changes to Make Binary String Beautiful
 */

// @lc code=start
class Solution
{
    public int minChanges(String s)
    {
        if(s.length() == 0)
        {
            return 0;
        }

        int minChange = 0;
        for(int i = 0; i < s.length() - 1; i += 2)
        {
            if(s.charAt(i) != s.charAt(i + 1))
            {
                minChange += 1;
            }
        }

        return minChange;
    }
}
// @lc code=end

