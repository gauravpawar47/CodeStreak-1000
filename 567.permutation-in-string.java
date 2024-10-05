/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution
{
    public static boolean matches(int[] freq1, int[] freq2)
    {
        for(int i = 0; i < 26; i++)
        {
            if(freq1[i] != freq2[i])
            {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2)
    {
        int l1 = s1.length();
        int l2 = s2.length();

        // Step 0 : Base-Case
        if(l1 > l2)
        {
            return false;
        }


        // Step 1 : Calculate Frequency for s1 and First Window of s2
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int i = 0; i < l1; i++)
        {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        // Step 2 : Compare Frequency of s1 with First Window of s2
        if(matches(freq1, freq2))
        {
            return true;    
        }

        // step 3 : Slide Window Over the Rest of s2
        for(int i = l1; i < l2; i++)
        {
            freq2[s2.charAt(i) - 'a']++; // Add New Char to Window
            freq2[s2.charAt(i - l1) - 'a']--; // Remove Old Char from Window

            // Step 4 : Check if Window Mathces Frequency
            if(matches(freq1, freq2))
            {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

