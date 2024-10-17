/*
 * @lc app=leetcode id=670 lang=java
 *
 * [670] Maximum Swap
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Collections;

class Solution
{
    public int maximumSwap(int num)
    {
        // Step 0 : Convert Number to Arraylist
        int temp = num;
        ArrayList<Integer> list = new ArrayList<>();

        while(temp > 0)
        {
            int ld = temp % 10;
            list.add(ld);
            temp /= 10; 
        }

        Collections.reverse(list); // Reverse in Correct Order
        int n = list.size();
        int[] maxRightIdx = new int[n]; // Array to Track maximum digit on right side of each position

        // Step 1 : Find max digit idx from right to left
        maxRightIdx[n - 1] = n - 1;
        for(int i = n - 2; i >= 0; i--)
        {
            if(list.get(i) > list.get(maxRightIdx[i + 1]))
            {
                maxRightIdx[i] = i;
            }
            else
            {
                maxRightIdx[i] = maxRightIdx[i + 1];
            }
        }

        // Step 3 : Find the First Largest Position to Maximize Swap
        for(int i = 0; i < n; i++)
        {
            if(list.get(i) < list.get(maxRightIdx[i]))
            {
                int tempDigit = list.get(i);
                list.set(i, list.get(maxRightIdx[i]));
                list.set(maxRightIdx[i], tempDigit);

                break; // After a Single Swap it should Break
            }
        }        

        // Step 3 : Convert the list to integer
        StringBuilder sb = new StringBuilder("");
        for(int digit : list)
        {
            sb.append(digit);
        }

        return Integer.parseInt(sb.toString());
    }
}
// @lc code=end

