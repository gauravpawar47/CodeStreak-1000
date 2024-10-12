/*
 * @lc app=leetcode id=2406 lang=java
 *
 * [2406] Divide Intervals Into Minimum Number of Groups
 */

// @lc code=start
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution
{
    public int minGroups(int[][] intervals)
    {
        // Step 1 : Sort the intervals by start times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Step 2 : Track End Times
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] interval : intervals)
        {
            int start = interval[0];
            int end = interval[1];

            // Step 3 : Check whether End is Less than Start
            if(!pq.isEmpty() && pq.peek() < start)
            {
                pq.poll();
            }

            pq.offer(end);
        }

        return pq.size();
    }
}
// @lc code=end

