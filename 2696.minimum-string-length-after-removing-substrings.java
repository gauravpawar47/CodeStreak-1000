/*
 * @lc app=leetcode id=2696 lang=java
 *
 * [2696] Minimum String Length After Removing Substrings
 */

// @lc code=start
class Solution
{
    public int minLength(String s)
    {
        while(s.contains("AB") || s.contains("CD"))
        {
            s = s.replaceAll("AB", "");
            s = s.replaceAll("CD", "");
        }    

        return s.length();
    }
}
// @lc code=end

