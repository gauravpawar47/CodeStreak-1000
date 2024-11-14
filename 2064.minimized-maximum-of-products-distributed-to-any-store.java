/*
 * @lc app=leetcode id=2064 lang=java
 *
 * [2064] Minimized Maximum of Products Distributed to Any Store
 */

// @lc code=start
class Solution
{
    public int minimizedMaximum(int n, int[] quantities)
    {
        int low = 1, high = 0;
        for (int quantity : quantities) 
        {
            high = Math.max(high, quantity);
        }
        
        while (low < high) 
        {
            int mid = (low + high) / 2;
            int storesNeeded = 0;
            
            for (int quantity : quantities) 
            {
                storesNeeded += (int) Math.ceil((double) quantity / mid);
            }
            
            if (storesNeeded <= n) 
            {
                high = mid;  // Try for a smaller maximum
            }
            else 
            {
                low = mid + 1;  // Need a larger maximum
            }
        }
        
        return low;
    }
}
// @lc code=end

