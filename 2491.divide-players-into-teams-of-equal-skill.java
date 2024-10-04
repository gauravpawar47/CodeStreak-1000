/*
 * @lc app=leetcode id=2491 lang=java
 *
 * [2491] Divide Players Into Teams of Equal Skill
 */

// @lc code=start
import java.util.Arrays;

class Solution
{
    public long dividePlayers(int[] skill)
    {
        // Step 1 : Sort the Array and Initialize Variables 
        Arrays.sort(skill);

        int expectedSum = skill[0] + skill[skill.length - 1];
        long chemistry = 0;

        // Step 2 : Make Pairs
        for(int i = 0; i < skill.length / 2; i++)
        {
            int left = skill[i];
            int right = skill[skill.length - i -  1];

            // Step 3 : Make Sum of Each Pair and Check their Equality
            if(left + right != expectedSum)
            {
                return -1;
            }

            // Step 4 : Calculate Chemistry
            chemistry += (long) (left * right);
        }

        // Step 5 : Return Chemistry
        return chemistry;
    }
}
// @lc code=end

