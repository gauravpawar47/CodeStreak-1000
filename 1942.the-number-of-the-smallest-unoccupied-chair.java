/*
 * @lc app=leetcode id=1942 lang=java
 *
 * [1942] The Number of the Smallest Unoccupied Chair
 */

// @lc code=start
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution
{
    public int smallestChair(int[][] times, int targetFriend)
    {
        // Step 1 : Populate events list with both arrival and departure time
        int n = times.length;
        List<int[]> events = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            events.add(new int[] {times[i][0], 1, i}); // 1 - Arrival
            events.add(new int[] {times[i][1], 0, i}); // 0 - Departure
        }

        // Step 2 : Sort Events by Time 
        events.sort((a, b) ->
        {
            if(a[0] != b[0])
            {
                return a[0] - b[0]; // Sort By Time
            }

            return a[1] - b[1];
        });

        // Step 3 : Min-Heap to Track Free Chairs
        PriorityQueue<Integer> freeChairs = new PriorityQueue<>();
        for(int i = 0; i < n; i++)
        {
            freeChairs.offer(i);
        }

        // Step 4 : Min-Heap to Track Currently Occupied Chairs
        PriorityQueue<int[]> occupied = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] chairAssigned = new int[n];

        for(int[] event : events)
        {
            int time = event[0];
            int type = event[1]; // Arrival
            int guestId = event[2];
            
            while(!occupied.isEmpty() && occupied.peek()[0] <= time)
            {
                int chairToFree = occupied.poll()[1];
                freeChairs.offer(chairToFree);
            }

            // Step 5 : If it's an Arrival Event
            if(type == 1)
            {
                int assignedChair = freeChairs.poll();
                chairAssigned[guestId] = assignedChair;
                
                occupied.offer(new int[] {times[guestId][1], assignedChair});
                if(guestId == targetFriend)
                {
                    return assignedChair;
                }
            }
        }

        return -1;
    }
}
// @lc code=end

