/*
 * @lc app=leetcode id=729 lang=java
 *
 * [729] My Calendar I
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class MyCalendar
{
    ArrayList<int[]> events; // Store events as pairs of [start, end]

    public MyCalendar()
    {
        events = new ArrayList<>();
    }

    public boolean book(int start, int end)
    {
        // Create the new event pair
        int[] newEvent = new int[]{start, end};

        // Step 1: Check for overlap
        for (int[] event : events)
        {
            // If there's an overlap, return false
            if (newEvent[0] < event[1] && newEvent[1] > event[0])
            {
                return false;
            }
        }

        // Step 2: Add the event and sort
        events.add(newEvent);

        // Sorting the list by start time (optional if you want to maintain sorted order)
        Collections.sort(events, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] a, int[] b)
            {
                return Integer.compare(a[0], b[0]);
            }
        });

        return true; // Successfully booked the event
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

