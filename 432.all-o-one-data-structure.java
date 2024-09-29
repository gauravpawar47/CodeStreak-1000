/*
 * @lc app=leetcode id=432 lang=java
 *
 * [432] All O`one Data Structure
 */

// @lc code=start
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

class AllOne
{
    HashMap<String, Integer> map; // Store Key Count
    TreeMap<Integer, Set<String>> freq; // Store Value Count

    public AllOne()
    {
        map = new HashMap<>();
        freq = new TreeMap<>();
    }
    
    public void inc(String key)
    {
        int count = map.getOrDefault(key, 0); // Current Count

        // Remove Key from Freq
        if(count > 0)
        {
            Set<String> current = freq.get(count);
            current.remove(key);
            if(current.isEmpty())
            {
                freq.remove(count);
            }
        }       

        // Increse Count
        int newCount = count + 1;
        map.put(key, newCount); 
    
        // Add Key 
        freq.computeIfAbsent(newCount, k-> new HashSet<>()).add(key);
    }
    
    public void dec(String key)
    {
        if(!map.containsKey(key)) // Key Doesn't Exist
        {
            return;
        }

        int count = map.get(key); // Current COunt

        // Remove the key from Freq
        Set<String> current = freq.get(count);
        current.remove(key);

        if(current.isEmpty())
        {
            freq.remove(count); // Clean Up Memory
        }

        if(count == 1)
        {
            map.remove(key);
        }
        else
        {
            // Decrease Count 
            int newCount = count - 1;
            map.put(key, newCount);

            // Add Key
            freq.computeIfAbsent(newCount, k->new HashSet<>()).add(key);
        }
    }
    
    public String getMaxKey()
    {
        if(freq.isEmpty())
        {
            return "";
        }
        else
        {
            return freq.lastEntry().getValue().iterator().next();
        }
    }
    
    public String getMinKey()
    {
        if(freq.isEmpty())
        {
            return "";
        }
        else
        {
            return freq.firstEntry().getValue().iterator().next();
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
// @lc code=end

