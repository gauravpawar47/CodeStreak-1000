/*
 * @lc app=leetcode id=2490 lang=java
 *
 * [2490] Circular Sentence
 */

// @lc code=start
class Solution
{
    public boolean isCircularSentence(String sentence)
    {
        for(int i = 0; i < sentence.length() - 1; i++)
        {
            if(sentence.charAt(i) == ' ')
            {
                if(sentence.charAt(i - 1) != sentence.charAt(i + 1))
                {
                    return false;
                }
            }
        }

        return sentence.charAt(0) == sentence.charAt(sentence.length() - 1);
    }
}
// @lc code=end

