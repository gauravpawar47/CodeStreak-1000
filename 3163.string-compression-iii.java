/*
 * @lc app=leetcode id=3163 lang=java
 *
 * [3163] String Compression III
 */

// @lc code=start
class Solution
{
    public String compressedString(String word)
    {
        StringBuilder sb = new StringBuilder("");
        int count = 1;

        for(int i = 1; i < word.length(); i++)
        {
            if(word.charAt(i) == word.charAt(i - 1) && count < 9)
            {
                count++;
            }
            else
            {
                sb.append(Integer.toString(count));
                sb.append(word.charAt(i - 1));
                count = 1;
            }
        }

        sb.append(Integer.toString(count));
        sb.append(word.charAt(word.length() - 1));

        return sb.toString();
    }
}
// @lc code=end

