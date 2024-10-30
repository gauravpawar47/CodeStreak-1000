/*
 * @lc app=leetcode id=1671 lang=java
 *
 * [1671] Minimum Number of Removals to Make Mountain Array
 */

// @lc code=start
import java.util.Arrays;

class Solution
{
    public int minimumMountainRemovals(int[] nums)
    {
        int n = nums.length;
        if (n < 3) return 0;

        int[] leftLIS = new int[n];
        int[] rightLIS = new int[n];
        
        Arrays.fill(leftLIS, 1);
        Arrays.fill(rightLIS, 1);

        // Calculate the longest increasing subsequence from the left side
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (nums[i] > nums[j])
                {
                    leftLIS[i] = Math.max(leftLIS[i], leftLIS[j] + 1);
                }
            }
        }

        // Calculate the longest increasing subsequence from the right side (decreasing sequence)
        for (int i = n - 2; i >= 0; i--)
        {
            for (int j = n - 1; j > i; j--)
            {
                if (nums[i] > nums[j])
                {
                    rightLIS[i] = Math.max(rightLIS[i], rightLIS[j] + 1);
                }
            }
        }

        int maxMountainLength = 0;

        // Calculate the longest mountain sequence length
        for (int i = 1; i < n - 1; i++)
        {
            if (leftLIS[i] > 1 && rightLIS[i] > 1)
            {
                maxMountainLength = Math.max(maxMountainLength, leftLIS[i] + rightLIS[i] - 1);
            }
        }

        return n - maxMountainLength;
    }
}
// @lc code=end

