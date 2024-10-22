/*
 * @lc app=leetcode id=2583 lang=java
 *
 * [2583] Kth Largest Sum in a Binary Tree
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
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.LinkedList;

class Solution
{
    public long kthLargestLevelSum(TreeNode root, int k)
    {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        while(!bfs.isEmpty())
        {
            int size = bfs.size();
            long sum = 0;

            for(int i = 0; i < size; i++)
            {
                TreeNode pop = bfs.remove();
                sum += pop.val;

                if(pop.left != null)
                {
                    bfs.add(pop.left);
                }
                if(pop.right != null)
                {
                    bfs.add(pop.right);
                }
            }

            pq.add(sum);
            if(pq.size() > k)
            {
                pq.remove();
            }
        }
        if(pq.size() < k)
        {
            return -1;
        }
        return pq.peek();
    }
}
// @lc code=end

