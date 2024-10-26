/*
 * @lc app=leetcode id=2458 lang=java
 *
 * [2458] Height of Binary Tree After Subtree Removal Queries
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution
{
    // Array to Sotre the maximum height of the tree after remvoing each node
    static final int[] maxHeightAfterRemoval = new int[100001];
    int currentMaxHeight = 0;

    public int[] treeQueries(TreeNode root, int[] queries)
    {
        traverseLeftToRight(root, 0);
        currentMaxHeight = 0; // Reset for 2nd Traversal
        traverseRightToLeft(root, 0);

        // Process Queries and Build the Result Array
        int queryCount = queries.length;
        int[] queryResults = new int[queryCount];
    
        for(int i = 0; i < queryCount; i++)
        {
            queryResults[i] = maxHeightAfterRemoval[queries[i]];
        } 

        return queryResults;
    }

    public void traverseLeftToRight(TreeNode node, int currentHeight)
    {
        if(node == null)
        {
            return;
        }

        // Store the Maximum height if this node were removed
        maxHeightAfterRemoval[node.val] = currentMaxHeight;

        // Update the Current Maximum Height
        currentMaxHeight = Math.max(currentMaxHeight, currentHeight);

        // Traverse Left SubTree first then Right
        traverseLeftToRight(node.left, currentHeight + 1);
        traverseLeftToRight(node.right, currentHeight + 1);
    }

    public void traverseRightToLeft(TreeNode node, int currentHeight)
    {
        if(node == null)
        {
            return;
        }

        // Store the Maximum height if this node were removed
        maxHeightAfterRemoval[node.val] = Math.max(maxHeightAfterRemoval[node.val],currentMaxHeight);

        // Update the Current Maximum Height
        currentMaxHeight = Math.max(currentMaxHeight, currentHeight);

        // Traverse Right SubTree first then Left
        traverseRightToLeft(node.right, currentHeight + 1);
        traverseRightToLeft(node.left, currentHeight + 1);
    }
}
// @lc code=end

