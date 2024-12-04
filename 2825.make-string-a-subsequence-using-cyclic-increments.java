/*
 * @lc app=leetcode id=2825 lang=java
 *
 * [2825] Make String a Subsequence Using Cyclic Increments
 */

// @lc code=start
class Solution
{
    public boolean canMakeSubsequence(String str1, String str2)
    {
        // Step 1: Initialize two pointers, i for s and j for t
        int j = 0; // Pointer for string t

        // Step 2: Loop through string s
        for(int i = 0; i < str1.length() && j < str2.length(); i++)
        {   
            // Step 3: Get the current character in s
            char current = str1.charAt(i);

            // Step 4: Compute the cyclic increment
            char next = current == 'z' ? 'a' : (char) (current + 1);

            // Step 5: Check if current or its cyclic increment matches t[j]
            if(current == str2.charAt(j) || next == str2.charAt(j))
            {
                j++; // Move to the next character in t
            }
        }

        // Step 6: If we have matched all characters of t, return true
        return j == str2.length();
    }
}
// @lc code=end

