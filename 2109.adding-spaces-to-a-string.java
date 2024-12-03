/*
 * @lc app=leetcode id=2109 lang=java
 *
 * [2109] Adding Spaces to a String
 */

// @lc code=start
class Solution
{
    public String addSpaces(String s, int[] spaces)
    {
        // Step 1: Create a StringBuilder to build the final result
        StringBuilder sb = new StringBuilder();
        
        // Step 2: Initialize a pointer for the 'spaces' array
        int j = 0; 
        
        // Step 3: Iterate through each character in the string 's'
        for (int i = 0; i < s.length(); i++)
        {
            
            // Step 4: Check if the current index matches the next space index
            if (j < spaces.length && spaces[j] == i)
            {
                // Step 4.1: Append a space to the StringBuilder
                sb.append(" ");
                // Step 4.2: Move the pointer 'j' to the next space index
                j++;
            }
            
            // Step 5: Append the current character to the StringBuilder
            sb.append(s.charAt(i));
        }
        
        // Step 6: Convert the StringBuilder to a string and return the result
        return sb.toString();
    }
}
// @lc code=end

