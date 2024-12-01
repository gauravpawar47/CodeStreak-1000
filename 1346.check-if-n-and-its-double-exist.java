/*
 * @lc app=leetcode id=1346 lang=java
 *
 * [1346] Check If N and Its Double Exist
 */

// @lc code=start
class Solution
{
    public boolean checkIfExist(int[] arr)
    {
        // Step 1: Iterate over each element in the array
        for (int i = 0; i < arr.length; i++)
        {
            // Step 2: Compute the target value (half of arr[i])
            float t = (float) arr[i] / 2; 
            
            // Step 3: Search for the target value in the array
            int x = Search(arr, t);
            
            // Step 4: Check if the found index is valid and different from 'i'
            if (x != i && x != -1)
            {
                return true; // Step 5: Return true if a valid pair is found
            }
        }

        return false; // Step 6: If no such pair is found, return false
    }

    static int Search(int[] arr, float target)
    {
        // Step 7: Iterate through the array to find the target value
        for (int i = 0; i < arr.length; i++)
        {
            // Step 8: Compare each element with the target
            if ((float) arr[i] == target) 
            {
                // Step 9: Return the index if the target is found
                return i; 
            }
        }
        
        // Step 10: Return -1 if the target is not found
        return -1; 
    }
}
// @lc code=end

