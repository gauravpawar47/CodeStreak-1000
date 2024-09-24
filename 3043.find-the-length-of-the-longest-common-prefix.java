/*
 * @lc app=leetcode id=3043 lang=java
 *
 * [3043] Find the Length of the Longest Common Prefix
 */

// @lc code=start
import java.util.HashSet;

class Solution
{
    public int longestCommonPrefix(int[] arr1, int[] arr2)
    {
        HashSet<String> prefixes = new HashSet<>();

        // Generate all prefixes from arr1
        for (int num : arr1)
        {
            String str = Integer.toString(num);
            for (int i = 1; i <= str.length(); i++) 
            {
                prefixes.add(str.substring(0, i)); // Add all prefixes
            }
        }

        int longestPrefixLength = 0;

        // Check each number in arr2 against the stored prefixes
        for (int num : arr2)
        {
            String str = Integer.toString(num);
            for (int i = 1; i <= str.length(); i++)
            {
                String currentPrefix = str.substring(0, i);
                if (prefixes.contains(currentPrefix))
                {
                    longestPrefixLength = Math.max(longestPrefixLength, currentPrefix.length());
                } 
                else
                {
                    break; // No point in checking longer prefixes if this one isn't found
                }
            }
        }
        return longestPrefixLength;
    }
}
// @lc code=end

