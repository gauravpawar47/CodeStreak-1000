/*
 * @lc app=leetcode id=862 lang=java
 *
 * [862] Shortest Subarray with Sum at Least K
 */

// @lc code=start
import java.util.*;

class Solution
{
    public int shortestSubarray(int[] nums, int k)
    {
        // Step 1 :  Initialize Variable Trackers 
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        long sum = 0;

        // Step 2 : Initialize Min Heap To Store Sum and Index
        PriorityQueue<Pair<Long, Integer>> prefixSum = new PriorityQueue<>((a, b) -> Long.compare(a.getKey(), b.getKey()));

        // Step 3 : Iterate through Array
        for(int i = 0; i < n; i++)
        {
            // Step 4 : Calculate Sum and Check Whether >= k
            sum += nums[i];
            if(sum >= k)
            {
                minLength = Math.min(minLength, i + 1);
            }

            // Step 5 : Remove Subarray from Heap that can form a Valid Subarray
            while(!prefixSum.isEmpty() && sum - prefixSum.peek().getKey() >= k)
            {
                // Step 6 : Update Shortest Subarray Length
                minLength = Math.min(minLength, i - prefixSum.poll().getValue());
            }

            prefixSum.offer(new Pair<>(sum, i));
        }

        // Step 7 : Return -1 if No Valid Subarray's Are to be Found
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
// @lc code=end

