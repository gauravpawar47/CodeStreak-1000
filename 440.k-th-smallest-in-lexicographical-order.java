/*
 * @lc app=leetcode id=440 lang=java
 *
 * [440] K-th Smallest in Lexicographical Order
 */

// @lc code=start
class Solution
{
    public int findKthNumber(int n, int k)
    {
        int current = 1;
        k--;

        while (k > 0)
        {
            int count = countNodesInSubtree(current, n);
            if (count <= k)
            {
                k -= count;  
                current++;   
            }
            else
            {
                k--;  
                current *= 10;
            }
        }

        return current;  
    }

    private int countNodesInSubtree(int current, int n)
    {
        long count = 0;
        long next = current + 1;  
        long cur = current;       

        while (cur <= n)
        {
            count += Math.min(n + 1, next) - cur;
            cur *= 10;  
            next *= 10;
        }

        return (int) count;
    }
}
// @lc code=end

