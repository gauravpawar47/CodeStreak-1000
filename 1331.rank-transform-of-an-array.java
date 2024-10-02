/*
 * @lc app=leetcode id=1331 lang=java
 *
 * [1331] Rank Transform of an Array
 */

// @lc code=start
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution
{
    public int[] arrayRankTransform(int[] arr) 
    {
        int[] rank = new int[arr.length];
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);    
    
        Map<Integer, Integer> map = new HashMap<>();
        int rankCounter = 1;

        for(int num : sortedArr)
        {
            if(!map.containsKey(num))
            {
                map.put(num, rankCounter++);
            }
        }
        for(int i = 0; i < arr.length; i++)
        {
            rank[i] = map.get(arr[i]);
        }
        
        return rank;
    }
}
// @lc code=end

