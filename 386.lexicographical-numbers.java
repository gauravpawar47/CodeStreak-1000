/*
 * @lc app=leetcode id=386 lang=java
 *
 * [386] Lexicographical Numbers
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Solution
{
    public List<Integer> lexicalOrder(int n)
    {
        List<Integer> result = new ArrayList<>();
        int current = 1;

        for(int i = 0; i < n; i++)
        {
            result.add(current);
            if(current * 10 <= n)
            {
                current *= 10;
            }
            else
            {
                if(current >= n)
                {
                    current /= 10;
                }
                current++;

                while (current % 10 == 0)
                {
                    current /= 10; 
                }
            }
        }

        return result;
    }
}
// @lc code=end

