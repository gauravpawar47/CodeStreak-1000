class Solution
{
    public List<String> wordSubsets(String[] words1, String[] words2)
    {
        // Step 1: Count the Frequency of Elements in words2
        int[] maxFreq = new int[26];
        for(String s : words2)
        {
            int[] freq = countFrequency(s);
            for(int i = 0; i < 26; i++)
            {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }

        // Step 2 : Create Result List for Universal Strings
        List<String> list = new ArrayList<>();

        // Step 3 : Check each words in words1 against maxFreq
        for(String word : words1)
        {
            int[] freq = countFrequency(word);
            if(isSubset(freq, maxFreq))
            {
                list.add(word);
            }
        }

        return list;
    }

    public int[] countFrequency(String s)
    {
        int freq[] = new int[26];
        for(int i = 0; i < s.length(); i++)
        {
            freq[s.charAt(i) - 'a']++;
        } 

        return freq;
    }

    public boolean isSubset(int[] freq, int[] maxFreq)
    {
        for(int i = 0; i < 26; i++)
        {
            if(freq[i] < maxFreq[i])
            {
                return false;
            }
        }

        return true;
    }
}