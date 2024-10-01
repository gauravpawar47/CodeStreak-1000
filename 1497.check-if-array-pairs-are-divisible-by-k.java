/*
 * @lc app=leetcode id=1497 lang=java
 *
 * [1497] Check If Array Pairs Are Divisible by k
 */

// @lc code=start
class Solution
{
    public boolean canArrange(int[] arr, int k)
    {
        // Frequency Of Each remainder
        int[] remainderCount = new int[k];
    
        // Calculate Remainder Frequencies
        for(int num : arr)
        {
            int remainder = ((num % k) + k) % k; // Non-Negative Integer
            remainderCount[remainder]++;
        }

        // Pairing Conditions
        for(int i = 1; i < k; i++)
        {
            if(remainderCount[i] != remainderCount[k - i])
            {
                return false;
            }
        }
        return remainderCount[0] % 2 == 0;
    }
}
// @lc code=end

