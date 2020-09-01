package com.study.august.week4;

/**
 * Sum of Left Leaves
 *
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 *
 */
public class Solution24 {

    public int sumOfLeftLeaves(TreeNode root) {
        // Initialize result
        int sum = 0;

        // Update result if root is not NULL
        if (root != null)
        {
            // If left of root is NULL, then add key of
            // left child
            if (isLeaf(root.left))
                sum += root.left.val;
            else // Else recur for left child of root
                sum += sumOfLeftLeaves(root.left);

            // Recur for right child of root and update res
            sum += sumOfLeftLeaves(root.right);
        }

        // return result
        return sum;
    }

    public boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null)
            return true;
        return false;
    }

    /**
     *
     * Definition for a binary tree node.
     *
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

