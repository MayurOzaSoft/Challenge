package com.study.april.week5;

/**
 * 
 * "Binary Tree Maximum Path Sum"
 * {@link https://leetcode.com/problems/binary-tree-maximum-path-sum/}
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution29 {

	int max;

	public int maxPathSum(TreeNode root) {

		max = Integer.MIN_VALUE;

		if (root == null)
			return 0;

		traverseNode(root);

		return max;
	}

	public int traverseNode(TreeNode root) {
		if (root == null)
			return 0;

		int leftSum = Math.max(0, traverseNode(root.left));
		int rightSum = Math.max(0, traverseNode(root.right));

		max = Math.max(max, leftSum + rightSum + root.val);

		return Math.max(leftSum, rightSum) + root.val;

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
