/*
 * @lc app=leetcode id=1963 lang=java
 *
 * [1963] Minimum Number of Swaps to Make the String Balanced
 */

// @lc code=start
class Solution
{
    public int minSwaps(String s)
    {
        int imbalance = 0;
        int swap = 0;

        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '[')
            {
                imbalance--;
            }
            else
            {
                imbalance++;
            }

            if(imbalance > 0)
            {
                swap++;
                imbalance -= 2;
            }
        }    

        return swap;
    }
}
// @lc code=end

