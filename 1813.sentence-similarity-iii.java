/*
 * @lc app=leetcode id=1813 lang=java
 *
 * [1813] Sentence Similarity III
 */

// @lc code=start
class Solution
{
    public boolean areSentencesSimilar(String sentence1, String sentence2)
    {
        // Step 1 : Split Both Sentence into Array of Words
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
    
        // Step 2 : Ensure s1 should be Greater than s2
        if(s1.length < s2.length)
        {
            String[] temp = s1;
            s1 = s2;
            s2 = temp;
        }

        // Step 3 : Find Common Prefix 
        int prefix = 0;
        while(prefix < s2.length && s1[prefix].equals(s2[prefix]))
        {
            prefix++;
        }

        // Step 4 : Find Common Suffix
        int suffix = 0;
        while(suffix < s2.length && s1[s1.length - 1 - suffix].equals(s2[s2.length - 1 - suffix]))
        {
            suffix++;
        }

        // Step 5 : Check if prefix and suffix >= word2
        return prefix + suffix >= s2.length;
    }
}
// @lc code=end

