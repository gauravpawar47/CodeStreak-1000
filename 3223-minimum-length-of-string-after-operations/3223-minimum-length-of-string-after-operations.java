class Solution
{
    public int searchLeft(int start, boolean[] map, String s, char ch)
    {
        while(start >= 0)
        {
            if(ch == s.charAt(start) && map[start] == false)
            {
                return start;
            }
            start--;
        }

        return -1;
    }

    public int searchRight(int start, boolean[] map, String s, char ch)
    {
        while(start < s.length())
        {
            if(ch == s.charAt(start) && map[start] == false)
            {
                return start;
            }
            start++;
        }

        return -1;
    }

    public int minimumLength(String s) 
    {
        if(s.length() <= 2)
        {
            return s.length();
        }    

        int count = 0;
        boolean[] map = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++)
        {
            if(map[i] == false)
            {
                char ch = s.charAt(i);
                int leftIdx = searchLeft(i - 1, map, s, ch);
                int rightIdx = searchRight(i + 1, map, s, ch);

                if(leftIdx != -1 && rightIdx != -1)
                {
                    map[leftIdx] = true;
                    map[rightIdx] = true;
                    count += 2;
                }
            }
        }

        return s.length() - count;
    }
}