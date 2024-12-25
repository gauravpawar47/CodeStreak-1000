/*
 * @lc app=leetcode id=515 lang=java
 *
 * [515] Find Largest Value in Each Tree Row
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
import java.util.*;

class Solution
{
    public List<Integer> largestValues(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        if(root == null)
        {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty())
        {
            int levelSize = queue.size();
            int maxValue = Integer.MIN_VALUE;

            for(int i = 0; i < levelSize; i++)
            {
                TreeNode current = queue.poll();
                maxValue = Math.max(maxValue, current.val);
            
                if(current.left != null)
                {
                    queue.offer(current.left);
                }

                if(current.right != null)
                {
                    queue.offer(current.right);
                }
            }

            result.add(maxValue);
        }

        return result;
    }
}
// @lc code=end

