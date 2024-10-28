/*
 * @lc app=leetcode id=2501 lang=java
 *
 * [2501] Longest Square Streak in an Array
 */

// @lc code=start
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Solution
{
    public int longestSquareStreak(int[] nums)
    {
        Arrays.sort(nums);
        // Set to keep track of numbers we've already processed
        Set<Integer> processedNumbers = new HashSet<>();
        int longestStreak = 0;

        // Iterate through each number in the sorted array
        for (int current : nums)
        {
            // Skip if we've already processed this number
            if (processedNumbers.contains(current))
            {
                continue;
            } 

            int streak = current;
            int streakLength = 1;

            // Continue the streak as long as we can find the square of the current number
            while (true)
            {
                // Break if the square would be larger than 10^5 (problem constraint)
                if ((long) streak * (long) streak > 1e5)
                {
                    break;
                } 
                // If we find the square, continue the streak
                if (binarySearch(nums, streak * streak))
                {
                    streak *= streak;
                    processedNumbers.add(streak);
                    streakLength++;
                }
                else
                {
                    break;
                }
            }
            // Update the longest streak if necessary
            longestStreak = Math.max(longestStreak, streakLength);
        }

        // Return -1 if no valid streak found, otherwise return the longest streak
        return longestStreak < 2 ? -1 : longestStreak;
    }

    // Binary search helper function to efficiently find a value in the sorted array
    private boolean binarySearch(int[] nums, int target)
    {
        if (target < 0)
        {
            return false;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target)
            {
                return true;
            } 
            if (nums[mid] > target)
            {
                right = mid - 1;
            } 
            else
            {
                left = mid + 1;
            } 
        }

        return false;
    }
}
// @lc code=end
