package com.study.april.week2;

/**
 * Diameter of Binary Tree
 *
 * 
 * Given a binary tree, you need to compute the length of the diameter of the
 * tree. The diameter of a binary tree is the length of the longest path between
 * any two nodes in a tree. This path may or may not pass through the root.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution13 {
	int height;

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 0;

		height = 1;

		height(root);

		return height - 1;

	}

	private int height(TreeNode root) {
		if (root == null)
			return 0;

		int leftMax = height(root.left);
		int rightMax = height(root.right);

		height = Math.max(height, leftMax + rightMax + 1);

		return 1 + Math.max(leftMax, rightMax);
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
	}

}
