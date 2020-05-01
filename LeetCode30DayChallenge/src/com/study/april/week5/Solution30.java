package com.study.april.week5;

/**
 * Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary
 * Tree
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution30 {

	public boolean isValidSequence(TreeNode root, int[] arr) {
		if (root == null)
			return arr.length == 0;
		return isValid(root, arr, 0);
	}

	public boolean isValid(TreeNode root, int[] arr, int index) {
		if (root.val != arr[index])
			return false;

		if (index == arr.length - 1)
			return root.left == null && root.right == null;

		return (root.left != null && isValid(root.left, arr, index + 1))
				|| (root.right != null && isValid(root.right, arr, index + 1));
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
