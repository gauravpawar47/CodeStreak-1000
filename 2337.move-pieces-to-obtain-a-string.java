/*
 * @lc app=leetcode id=2337 lang=java
 *
 * [2337] Move Pieces to Obtain a String
 */

// @lc code=start
class Solution
{
    public boolean canChange(String start, String target)
    {
        // Step 1: Convert strings to character arrays for traversal
        char[] s = start.toCharArray();
        char[] t = target.toCharArray();

        int n = s.length;
        int i = 0; 
        int j = 0;

        // Step 2: Traverse both arrays using pointers
        while(i <= n && j <= n)
        {
            // Step 3: Skip blank spaces ('_') in both arrays
            while(i < n && s[i] == '_')
            {
                i++;
            }

            while(j < n && t[j] == '_')
            {
                j++;
            }

            // Step 4: If either pointer reaches the end, ensure both are at the end
            if(i == n || j == n)
            {
                return i == n && j == n;
            }

            // Step 5: Compare aligned characters
            if(s[i] != t[j])
            {
                return false;
            }

            // Step 6: Check movement constraints
            if(s[i] == 'L' && i < j)
            {
                return false;
            }
            
            if(s[i] == 'R' && i > j)
            {
                return false;
            }

            // Step 7: Move both pointers to the next character
            j++;
            i++;
        }    

        // Step 8: If all checks pass, the transformation is valid
        return true;
    }
}
// @lc code=end

