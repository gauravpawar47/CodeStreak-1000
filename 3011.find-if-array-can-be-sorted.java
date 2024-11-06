/*
 * @lc app=leetcode id=3011 lang=java
 *
 * [3011] Find if Array Can Be Sorted
 */

// @lc code=start
class Solution
{
    public static boolean equality(int a, int b)
    {
        return Integer.bitCount(a) == Integer.bitCount(b);
    } 

    public static boolean canSortArray(int[] nums)
    {
        for(int i = 0 ; i < nums.length - 1; i++)
        {
            for(int j = 0; j < nums.length - i - 1; j++)
            {
                if(nums[j] > nums[j + 1])
                {
                    if(!equality(nums[j], nums[j + 1]))
                    {
                        return false;
                    }
                    else
                    {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
        }    

        return true;
    }
}
// @lc code=end

