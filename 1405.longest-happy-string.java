/*
 * @lc app=leetcode id=1405 lang=java
 *
 * [1405] Longest Happy String
 */

// @lc code=start
import java.util.PriorityQueue;

class Solution
{
    class Pair
    {
        char ch;
        int count;
    
        Pair(char ch, int count)
        {
            this.ch = ch;
            this.count = count;
        }
    }

    public String longestDiverseString(int a, int b, int c)
    {
        // Step 1 : Create a Min Heap (Priority Queue)
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.count - p1.count);

        if(a > 0)
        {
            pq.offer(new Pair('a', a));
        }
        if(b > 0)
        {
            pq.offer(new Pair('b', b));
        }
        if(c > 0)
        {
            pq.offer(new Pair('c', c));
        }

        // Step 2 : Traverse till pq becomes empty
        StringBuilder sb = new StringBuilder("");
        while(!pq.isEmpty())
        {
            Pair first = pq.poll();

            if(sb.length() >= 2 && sb.charAt(sb.length() - 1) == first.ch && sb.charAt(sb.length() - 2) == first.ch)
            {
                // Step 3 : If first has already twice appearence then look for second pair
                if(pq.isEmpty())
                {
                    break;
                }         

                Pair second = pq.poll();
                sb.append(second.ch);
                second.count -= 1;

                if(second.count > 0) 
                {
                    pq.offer(second);
                }           
                pq.offer(first); // Since first is not used it must be offered again in pq
            } 
            else // Step 4 : Appending first again in sb
            {
                sb.append(first.ch);
                first.count -= 1;
                if(first.count > 0)
                {
                    pq.offer(first);
                }
            }
        }
        return sb.toString();
    }
}
// @lc code=end

