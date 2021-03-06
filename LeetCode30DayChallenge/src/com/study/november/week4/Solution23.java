package com.study.november.week4;

import java.util.HashMap;
import java.util.Map;

/**
 * House Robber III
 *
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 *
 * Example 2:
 *
 * Input: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 */
public class Solution23 {

    Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob_III(TreeNode root){
        if(root == null) return 0;

        if(memo.containsKey(root)) return memo.get(root);


        int sum = root.val;

        if(root.left != null){
            sum += rob_III(root.left.left);
            sum += rob_III(root.left.right);
        }

        if(root.right != null){
            sum += rob_III(root.right.left);
            sum += rob_III(root.right.right);
        }

        int nextSum = rob_III(root.left) + rob_III(root.right);
        int result = Math.max(sum, nextSum);
        memo.put(root, result);

        return result;

    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
