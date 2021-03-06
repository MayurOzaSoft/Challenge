package com.study.may.week4;

/**
 * Construct Binary Search Tree from Preorder Traversal
 * 
 * 
 * Return the root node of a binary search tree that matches the given preorder
 * traversal.
 * 
 * (Recall that a binary search tree is a binary tree where for every node, any
 * descendant of node.left has a value < node.val, and any descendant of
 * node.right has a value > node.val. Also recall that a preorder traversal
 * displays the value of the node first, then traverses node.left, then
 * traverses node.right.)
 * 
 * It's guaranteed that for the given test cases there is always possible to
 * find a binary search tree with the given requirements.
 *
 * 
 * Input: [8,5,1,7,10,12]
 * 
 * Output: [8,5,10,1,7,null,12]
 * 
 * Constraints:
 * 
 * 1 <= preorder.length <= 100
 * 
 * 1 <= preorder[i] <= 10^8
 * 
 * The values of preorder are distinct.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution24 {
	TreeNode root;

	public TreeNode bstFromPreorder(int[] preorder) {

		for (int i = 0; i < preorder.length; i++)
			preOrderInsert(preorder[i]);

		return root;
	}

	private void preOrderInsert(int val) {

		if (root == null) {
			root = new TreeNode(val, null, null);
			return;
		}

		TreeNode current = root;
		TreeNode node = new TreeNode(val, null, null);

		while (true) {
			if (current.val > val) {
				if (null == current.left) {
					current.left = node;
					break;
				} else
					current = current.left;
			} else if (null == current.right) {
				current.right = node;
				break;
			} else
				current = current.right;

		}

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
