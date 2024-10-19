/*
 * @lc app=leetcode id=1545 lang=java
 *
 * [1545] Find Kth Bit in Nth Binary String
 */

// @lc code=start
class Solution
{
    public char findKthBit(int n, int k)
    {
        StringBuilder seq = new StringBuilder("0");

        for(int i = 1; i < n && k > seq.length(); ++i)
        {
            seq.append('1');
            for(int j = seq.length() - 2; j >= 0; --j)
            {
                char inverted = (seq.charAt(j) == '1') ? '0' : '1';
                seq.append(inverted);
            }
        }    

        return seq.charAt(k - 1);
    }
}
// @lc code=end

