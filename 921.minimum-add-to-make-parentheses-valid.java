/*
 * @lc app=leetcode id=921 lang=java
 *
 * [921] Minimum Add to Make Parentheses Valid
 */

// @lc code=start
class Solution
{
    public int minAddToMakeValid(String s)
    {
        int balance = 0;
        int moves = 0;

        for(char c : s.toCharArray())
        {
            if(c == '(')
            {
                balance++;
            }
            else
            {
                if(balance > 0)
                {
                    balance--;
                }
                else
                {
                    moves++;
                }
            }
        }    
        return moves + balance;
    }
}
// @lc code=end

