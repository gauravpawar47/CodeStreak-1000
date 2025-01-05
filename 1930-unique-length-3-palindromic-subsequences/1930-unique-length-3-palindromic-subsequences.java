class Solution
{
    public int countPalindromicSubsequence(String s)
    {
        int result = 0;
        for(char ch ='a'; ch <= 'z'; ch++)
        {
            int first = s.indexOf(ch);
            int last = s.lastIndexOf(ch);
        
            if(first != -1 && last != -1 && last - first > 1)
            {
                HashSet<Character> uniqueMiddle = new HashSet<>();
                for(int i = first + 1; i < last; i++)
                {
                    uniqueMiddle.add(s.charAt(i));
                }
                result += uniqueMiddle.size();
            }
        }    

        return result;
    }
}