/*
 * @lc app=leetcode id=2707 lang=java
 *
 * [2707] Extra Characters in a String
 */

// @lc code=start
import java.util.Arrays;

class Solution
{
    public int minExtraChar(String s, String[] dictionary)
    {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Base case: no extra characters at the start of the string

        // Iterate through each position in the string
        for (int i = 1; i <= n; i++)
        {
            // Consider the case where s.charAt(i-1) is an extra character
            dp[i] = dp[i - 1] + 1;

            // Try matching substrings ending at index i-1
            for (String word : dictionary)
            {
                int wordLen = word.length();
                if (i >= wordLen && s.substring(i - wordLen, i).equals(word))
                {
                    dp[i] = Math.min(dp[i], dp[i - wordLen]);
                }
            }
        }

        // The result is stored in dp[n], which represents the full string
        return dp[n];
    }
}
// @lc code=end

