/*
 * @lc app=leetcode id=731 lang=java
 *
 * [731] My Calendar II
 */

// @lc code=start
import java.util.ArrayList;

class MyCalendarTwo
{
    ArrayList<int[]> events; // Pairs
    ArrayList<int[]> overlaps; // Double Bookings

    public MyCalendarTwo()
    {
        events = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int start, int end)
    {
        // Step 1 : Check if New Event Causes a Triple Overlap
        for(int[] overlap : overlaps)
        {
            if(start < overlap[1] && end > overlap[0])
            {
                return false;
            }            
        }    

        // Step 2 : Check for Overlaps
        for(int[] event : events)
        {
            if(start < event[1] && end > event[0])
            {
                int overlapStart = Math.max(start, event[0]);
                int overlapEnd = Math.min(end, event[1]);
                overlaps.add(new int[]{overlapStart, overlapEnd});
            }
        }

        // Step 3 : Add New Events
        events.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

