class Solution
{
    public String shiftingLetters(String s, int[][] shifts)
    {
        int n = s.length();
        int[] diff = new int[n + 1];
        
        // Apply the shifts
        for (int[] shift : shifts)
        {
            diff[shift[0]] += (shift[2] == 1) ? 1 : -1;
            if (shift[1] + 1 < n) 
            {
                diff[shift[1] + 1] += (shift[2] == 1) ? -1 : 1;
            }
        }
        
        int shiftSum = 0;
        StringBuilder result = new StringBuilder(s);
        
        // Process the shifts on the string
        for (int i = 0; i < n; ++i)
        {
            shiftSum = (shiftSum + diff[i]) % 26;
            if (shiftSum < 0)
            {
                shiftSum += 26;
            }
                
            result.setCharAt(i, (char) ('a' + (result.charAt(i) - 'a' + shiftSum) % 26));
        }
        
        return result.toString();
    }
}