/*
 * @lc app=leetcode id=1593 lang=java
 *
 * [1593] Split a String Into the Max Number of Unique Substrings
 */

// @lc code=start
import java.util.HashSet;

class Solution
{
    public static int backtrack(String s, int start, HashSet<String> seen)
    {
        if(start == s.length())
        {
            return 0;
        }

        int maxSplit = 0;
        for(int i = start + 1; i <= s.length(); i++)
        {
            String substring = s.substring(start, i);
            if(!seen.contains(substring))
            {
                seen.add(substring);
                maxSplit = Math.max(maxSplit, 1 + backtrack(s, i, seen));
                seen.remove(substring);
            }
        }

        return maxSplit;
    }

    public int maxUniqueSplit(String s)
    {
        return backtrack(s, 0, new HashSet<>());
    }
}
// @lc code=end

