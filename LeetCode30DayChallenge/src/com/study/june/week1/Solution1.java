package com.study.june.week1;

/**
 * Invert Binary Tree
 * 
 * Input : [4,2,7,1,3,6,9]
 * 
 * Output : [4,7,2,9,6,3,1]
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution1 {

	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;

		TreeNode leftNode = invertTree(root.left);
		TreeNode rightNode = invertTree(root.right);

		root.left = rightNode;
		root.right = leftNode;

		return root;

	}

	/**
	 * Definition for a binary tree node.
	 */
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
