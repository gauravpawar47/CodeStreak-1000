/*
 * @lc app=leetcode id=2530 lang=java
 *
 * [2530] Maximal Score After Applying K Operations
 */

// @lc code=start
class Solution
{
    public long maxKelements(int[] nums, int k)
    {
        PriorityQueue<Integer>pq = new PriorityQueue<>((a, b)->b-a);
        for(int x : nums)
        {
            pq.offer(x);
        }    
    
        long score = 0; 
        while(!pq.isEmpty() && k>0)
        {
            score +=pq.peek();
            int x = (int)Math.ceil(pq.poll()/3.0);
            pq.add(x);
            k--;
        }
        return score;
    }
}
// @lc code=end

