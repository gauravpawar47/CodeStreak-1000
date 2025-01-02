class Solution
{
    public int[] vowelStrings(String[] words, int[][] queries)
    {
        int n = words.length;
        int[] prefixSum = new int[n + 1];
        int[] result = new int[queries.length];
        
        // Step 1 : Calculate Prefix Sum
        for(int i = 0; i < n; i++)
        {
            prefixSum[i + 1] = prefixSum[i] + (isVowel(words[i]) ? 1 : 0);
        }

        // Step 2 : Count the Result

        for (int i = 0; i < queries.length; i++)
        {
            int start = queries[i][0];
            int end = queries[i][1];
            result[i] = prefixSum[end + 1] - prefixSum[start];
        }
        
        return result;
    }

    private boolean isVowel(String str)
    {
        return isVowelChar(str.charAt(0)) && isVowelChar(str.charAt(str.length() - 1));
    }

    private boolean isVowelChar(char c)
    {
        return "aeiou".indexOf(c) != -1; // Checks if character is in the vowel set
    }
}