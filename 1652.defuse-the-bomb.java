/*
 * @lc app=leetcode id=1652 lang=java
 *
 * [1652] Defuse the Bomb
 */

// @lc code=start
class Solution
{
    public int[] decrypt(int[] code, int k)
    {
        int n = code.length;
        int[] result = new int[n];

        // Step 1 : If k == 0, all the elements Become 0
        if(k == 0)
        {
            return result;
        }    

        // Step 2 : Iterate Over the Array and Compute Results
        for(int i = 0; i < n; i++)
        {
            int sum = 0;
            if(k > 0)
            {
                // Step 3 : Calculate Sum of next K Elements
                for(int j = 1; j <= k; j++)
                {
                    sum += code[(i + j) % n];
                }
            }
            else
            {
                // Step 4 : Calculate Sum of Previous |k| Elements 
                for(int j = 1; j <= -k; j++)
                {
                    sum += code[(i - j + n) % n];
                }
            }
        
            result[i] = sum;
        }

        return result;
    }
}
// @lc code=end

