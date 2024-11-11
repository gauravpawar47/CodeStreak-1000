/*
 * @lc app=leetcode id=2601 lang=java
 *
 * [2601] Prime Subtraction Operation
 */

// @lc code=start
class Solution
{
    private boolean checkCondition(int[] nums)
    {
        int cnt = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++)
        {
            if (nums[i] >= nums[i + 1])
            {
                cnt++;
            }
        }
        return cnt == 0;
    }

    private boolean isPrime(int num)
    {
        if (num < 2)
        {
            return false;
        }
        
        int val = (int) Math.sqrt(num);
        for (int i = 2; i <= val; i++)
        {
            if (num % i == 0)
            {
                return false;
            }
        }

        return true;
    }

    public boolean primeSubOperation(int[] nums)
    {
        int n = nums.length;
        if (checkCondition(nums))
        {
            return true;
        }

        for (int i = 0; i < n; i++)
        {
            int bound = (i == 0) ? nums[0] : nums[i] - nums[i - 1];
            if (bound <= 0)
            {
                return false;
            }

            int largestPrime = 0;
            for (int j = bound - 1; j >= 2; j--)
            {
                if (isPrime(j))
                {
                    largestPrime = j;
                    break;
                }
            }

            if (largestPrime > 0)
            {  // Check if a prime was found
                nums[i] -= largestPrime;
            }
        }

        return checkCondition(nums);
    }
}
// @lc code=end

