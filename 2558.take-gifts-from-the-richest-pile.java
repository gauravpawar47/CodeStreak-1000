/*
 * @lc app=leetcode id=2558 lang=java
 *
 * [2558] Take Gifts From the Richest Pile
 */

// @lc code=start
import java.util.PriorityQueue;

class Solution
{
    public long pickGifts(int[] g, int k)
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int val : g)
        {
            maxHeap.add(val);
        }

        for (int i = 0; i < k && maxHeap.peek() > 1; i++)
        {
            int x = maxHeap.poll();
            maxHeap.add((int) Math.sqrt(x));
        }

        long sum = 0;
        for (int val : maxHeap)
        {
            sum += val;
        }

        return sum;
    }
}
// @lc code=end

