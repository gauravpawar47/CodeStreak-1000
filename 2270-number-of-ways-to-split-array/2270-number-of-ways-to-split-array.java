class Solution
{
    public int waysToSplitArray(int[] nums)
    {
        // Step 1: Implement Forward Prefix Sum
        long[] prefixFor = new long[nums.length];
        prefixFor[0] = nums[0];
    
        for (int i = 1; i < nums.length; i++)
        {
            prefixFor[i] = prefixFor[i - 1] + nums[i];
        }

        // Step 2: Implement Reverse Prefix Sum
        long[] prefixRev = new long[nums.length];
        prefixRev[nums.length - 1] = nums[nums.length - 1];
        
        for (int i = nums.length - 2; i >= 0; i--)
        {
            prefixRev[i] = prefixRev[i + 1] + nums[i];
        }

        // Step 3: Calculate Valid Splits
        int splits = 0;
        for (int i = 0; i < prefixFor.length - 1; i++)
        {
            if (prefixFor[i] >= prefixRev[i + 1])
            {
                splits++;
            }
        }

        return splits;
    }
}