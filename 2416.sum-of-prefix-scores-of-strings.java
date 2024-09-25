/*
 * @lc app=leetcode id=2416 lang=java
 *
 * [2416] Sum of Prefix Scores of Strings
 */

// @lc code=start
import java.util.*;

class TrieNode
{
    Map<Character, TrieNode> children;
    int count;

    public TrieNode()
    {
        children = new HashMap<>();
        count = 0;
    }
}

class Trie
{
    private TrieNode root;

    public Trie()
    {
        root = new TrieNode();
    }

    // Insert a word into the Trie and update counts
    public void insert(String word)
    {
        TrieNode node = root;
        for (char ch : word.toCharArray())
        {
            if (!node.children.containsKey(ch))
            {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
            node.count++;
        }
    }

    // Calculate the prefix score for a given word
    public int getPrefixScore(String word)
    {
        TrieNode node = root;
        int prefixScore = 0;
    
        for (char ch : word.toCharArray())
        {
            node = node.children.get(ch);
            prefixScore += node.count;
        }
        
        return prefixScore;
    }
}

public class Solution
{
    public static int[] sumPrefixScores(String[] words)
    {
        Trie trie = new Trie();

        // Step 1: Insert all words into the Trie
        for (String word : words)
        {
            trie.insert(word);
        }

        // Step 2: Calculate the total prefix score for each word
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++)
        {
            result[i] = trie.getPrefixScore(words[i]);
        }
        return result;
    }
}
// @lc code=end

