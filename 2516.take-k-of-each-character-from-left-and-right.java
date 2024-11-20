/*
 * @lc app=leetcode id=2516 lang=java
 *
 * [2516] Take K of Each Character From Left and Right
 */

// @lc code=start
class Solution
{
    public int takeCharacters(String s, int k)
    {
        // Step 1 : Total Counts
        int[] freq = new int[3];
        for(char c : s.toCharArray())
        {
            freq[c - 'a']++;
        }    

        // Step 2 : Check If any Character's Frequency < k
        if(Math.min(Math.min(freq[0], freq[1]), freq[2]) < k)
        {
            return -1;
        }

        // Step 3 : Sliding Window
        int result = Integer.MAX_VALUE;
        int left = 0;
        
        for(int right = 0; right < s.length(); right++)
        {
            freq[s.charAt(right) - 'a']--;

            while(Math.min(Math.min(freq[0], freq[1]), freq[2]) < k)
            {
                freq[s.charAt(left) - 'a']++;
                left++;
            }

            result = Math.min(result, s.length() - (right - left + 1));
        }

        return result;
    }
}
// @lc code=end

