class Solution 
{
    public boolean canBeValid(String s, String locked) 
    {
        if(s.length() % 2 != 0)
        {
            return false;
        }

        int openCount = 0;
        int freeCount = 0;

        for(int i = 0; i < s.length(); i++)
        {
            if(locked.charAt(i) == '0')
            {
                freeCount++;
            }
            else if(s.charAt(i) == '(')
            {
                openCount++;
            }
            else
            {
                if(openCount > 0)
                {
                    openCount--;
                }
                else if(freeCount > 0)
                {
                    freeCount--;
                }
                else
                {
                    return false;
                }
            }
        }
        
        int closeCount = 0;
        freeCount = 0;

        for(int i = s.length() - 1; i >= 0; i--)
        {
            if(locked.charAt(i) == '0')
            {
                freeCount++;
            }
            else if(s.charAt(i) == ')')
            {
                closeCount++;
            }
            else
            {
                if(freeCount > 0)
                {
                    freeCount--;
                }
                else if(closeCount > 0)
                {
                    closeCount--;
                }
                else
                {
                    return false;
                }
            }
        }

        return true;
    }
}
