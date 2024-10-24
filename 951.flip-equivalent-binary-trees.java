/*
 * @lc app=leetcode id=951 lang=java
 *
 * [951] Flip Equivalent Binary Trees
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
    public boolean flipEquiv(TreeNode root1, TreeNode root2)
    {
        // Both trees are empty
        if (root1 == null && root2 == null)
        {
            return true;
        }
        
        // Just one of the trees is empty
        if (root1 == null || root2 == null)
        {
            return false;
        }
        
        // Corresponding values differ
        if (root1.val != root2.val)
        {
            return false;
        }

        // Check if corresponding subtrees are flip equivalent
        boolean noSwap =
            flipEquiv(root1.left, root2.left) &&
            flipEquiv(root1.right, root2.right);
        
        // Check if opposite subtrees are flip equivalent
        boolean swap =
            flipEquiv(root1.left, root2.right) &&
            flipEquiv(root1.right, root2.left);

        return noSwap || swap;
    }
}
// @lc code=end

