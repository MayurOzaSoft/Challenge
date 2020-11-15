package com.study.november.week3;

import java.util.Stack;

/**
 * Range Sum of BST
 *
 * Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
 *
 * Example 1:
 *
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 *
 * Example 2:
 *
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 2 * 104].
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * All Node.val are unique.
 *
 */
public class Solution15 {

    int result = 0;

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

    public int rangeSumBST_0ms(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return result;
    }

    public void dfs(TreeNode root, int low, int high){
        if(root == null) return;

        if(low <= root.val && root.val <= high)
            result += root.val;

        if(low < root.val)
            rangeSumBST_0ms(root.left, low, high);

        if(root.val < high)
            rangeSumBST_0ms(root.right, low, high);

    }

    public int rangeSumBST_TraversIterative_2ms(TreeNode root, int low, int high){
        int sum = 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            if(root != null){
                if(low <= root.val && root.val <= high)
                    sum += root.val;

                if(low < root.val)
                    stack.push(root.left);

                if(root.val < high)
                    stack.push(root.right);
            }
        }

        return sum;
    }

    public int rangeSumBST_Recursive_II_0ms(TreeNode root, int low, int high){
        if(root == null) return 0;

        if(root.val < low)
            return rangeSumBST_Recursive_II_0ms(root.left, low, high);

        if(root.val > high)
            return rangeSumBST_Recursive_II_0ms(root.right, low, high);


        return root.val + rangeSumBST_Recursive_II_0ms(root.left, low, high) + rangeSumBST_Recursive_II_0ms(root.right, low, high);
    }
}
