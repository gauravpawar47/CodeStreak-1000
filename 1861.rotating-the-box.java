/*
 * @lc app=leetcode id=1861 lang=java
 *
 * [1861] Rotating the Box
 */

// @lc code=start
class Solution
{
    public char[][] rotateTheBox(char[][] box)
    {
        // Step 1 : Declare Resultant Array
        int m = box.length;
        int n = box[0].length;
        char[][] result = new char[n][m];

        // Step 2 : Transpose The Entire Matrix
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                result[i][j] = box[j][i];
            }
        }

        // Step 3 : Reverse each row in Result to Complete 90° Rotation
        for(int i = 0; i < n; i++)
        {
            reverse(result[i]);
        }

        // Step 4 : Apply Gravity To Let Stones Fall on Lowest Possible Empty Cell
        for(int j = 0; j < m; j++)
        {
            // Step 5 : Process Each Cell in 'j' Column from Bottom to Top
            for(int i = n - 1; i >= 0; i--)
            {
                // Step 6 : Found An Empty Cell, Check If Stone can Fall
                if(result[i][j] == '.')
                {
                    int nxtRow = -1;
                    
                    // Step 7 : Look For Stone Above Empty Cell
                    for(int k = i - 1; k >= 0; k--)
                    {
                        // Step 8 : Break if Obstacle Found
                        if(result[k][j] == '*')
                        {
                            break;
                        }

                        // Step 9 : Store Index, If Stone Found
                        if(result[k][j] == '#')
                        {
                            nxtRow = k;
                            break;
                        }
                    }

                    // Step 10 : If Stone Found, Let It Fall on Ground
                    if(nxtRow != -1)
                    {
                        result[nxtRow][j] = '.';
                        result[i][j] = '#';
                    }

                }
            }
        }
        
        return result;    
    }


    public void reverse(char[] row)
    {
        int left = 0;
        int right = row.length - 1;

        while(left < right)
        {
            char temp = row[left];
            row[left] = row[right];
            row[right] = temp;

            left++;
            right--;
        }
    }
}
// @lc code=end

