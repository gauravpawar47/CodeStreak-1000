class Solution
{
    public int[] minOperations(String boxes)
    {
        int n = boxes.length();
        int[] result = new int[n];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(boxes.charAt(j) == '1')
                {
                    result[i] += Math.abs(j - i);
                }
            }
        }  

        return result;
    }
}