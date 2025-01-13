class Solution
{
    public boolean checkMiddle(int i, int j, String s)
    {
        while(i < j)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public boolean canConstruct(String s, int k)
    {
        if(s.length() < k)
        {
            return false;
        }
        
        if(s.length() == k)
        {
            return true;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int count = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            if(entry.getValue() % 2 != 0)
            {
                count++;
            }

            if(count > k)
            {
                return false;
            }
        }

        return true;
    }
}