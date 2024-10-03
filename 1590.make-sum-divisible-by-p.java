/*
 * @lc app=leetcode id=1590 lang=java
 *
 * [1590] Make Sum Divisible by P
 */

// @lc code=start
import java.util.HashMap;

class Solution
{
    public int minSubarray(int[] nums, int p)
    {
        // Step 1 : Calculate the Total Sum of the Array and its modulo with p

        long totalSum = 0;
        for(int num : nums)
        {
            totalSum += num;
        }    

        int remainder = (int)(totalSum % p);
        if(remainder == 0)
        {
            return 0;
        }

        // Step 2 : Initialize Variables to Store Prefix and Minimum Length

        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1);
        int currentPrefix = 0;
        int minLength = nums.length;

        // Step 3 : Iterate Over the Array to Find Smallest Subarray 

        for(int i = 0; i < nums.length; i++)
        {
            currentPrefix = (currentPrefix + nums[i]) % p;
            int targetMod = (currentPrefix - remainder + p) % p;

            if(prefixMap.containsKey(targetMod))
            {
                minLength = Math.min(minLength, i - prefixMap.get(targetMod));
            }

            prefixMap.put(currentPrefix, i);
        }

        // Step 4 : If No Valid Sub array is Found return -1
        
        return minLength == nums.length ? -1 : minLength;
    }
}
// @lc code=end

