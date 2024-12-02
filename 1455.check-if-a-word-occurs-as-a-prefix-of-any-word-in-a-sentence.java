/*
 * @lc app=leetcode id=1455 lang=java
 *
 * [1455] Check If a Word Occurs As a Prefix of Any Word in a Sentence
 */

// @lc code=start
class Solution
{
    public int isPrefixOfWord(String sentence, String searchWord)
    {
        // Step 1: Check if searchWord is longer than the entire sentence
        if (searchWord.length() > sentence.length())
        {
            return -1;
        }

        // Step 2: Split the sentence into words
        String[] words = sentence.split(" ");

        // Step 3: Iterate over the words array
        for (int i = 0; i < words.length; i++)
        {
            // Step 4: Skip words shorter than searchWord
            if (searchWord.length() > words[i].length())
            {
                continue;
            }

            // Step 5: Extract prefix of the current word
            String s = words[i].substring(0, searchWord.length());
            if (s.equals(searchWord))
            {
                return i + 1; // Return 1-based index
            }
        }

        // Step 7: If no match is found, return -1
        return -1;
    }
}
// @lc code=end

