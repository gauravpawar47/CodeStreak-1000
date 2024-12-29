/*
 * @lc app=leetcode id=1639 lang=java
 *
 * [1639] Number of Ways to Form a Target String Given a Dictionary
 */

// @lc code=start
public class Solution
{
    private static final int MOD = 1_000_000_007;

    public int numWays(String[] words, String target)
    {
        int m = target.length();
        int n = words[0].length();
        
        // Precompute character frequencies for each column
        int[][] charFrequency = new int[n][26];
        for (String word : words)
        {
            for (int j = 0; j < n; j++)
            {
                charFrequency[j][word.charAt(j) - 'a']++;
            }
        }
        
        // DP array: dp[targetIndex][columnIndex]
        int[] dp = new int[m + 1];
        dp[0] = 1; // Base case: 1 way to form an empty target
        
        for (int col = 0; col < n; col++)
        {
            // Traverse dp array in reverse to prevent overwriting results from the same column
            for (int targetIndex = m - 1; targetIndex >= 0; targetIndex--)
            {
                char targetChar = target.charAt(targetIndex);
                int count = charFrequency[col][targetChar - 'a'];
                
                if (count > 0)
                {
                    dp[targetIndex + 1] += (int) ((long) dp[targetIndex] * count % MOD);
                    dp[targetIndex + 1] %= MOD;
                }
            }
        }
        
        return dp[m];
    }
}
// @lc code=end

