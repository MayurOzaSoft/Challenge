package com.study.april.week3;

/**
 * Construct Binary Search Tree from Preorder Traversal
 * 
 * Input: [8,5,1,7,10,12] Output: [8,5,10,1,7,null,12]
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution20 {

	public TreeNode bstFromPreorder(int[] preorder) {

		if(preorder.length == 0) return new TreeNode(0); 

		TreeNode root = new TreeNode(preorder[0]);

		for(int i = 1; i < preorder.length; i ++){
			root = bstAddPreOrder(preorder[i], root);
		}

		return root;
	}

	private TreeNode bstAddPreOrder(int val, TreeNode root){

		TreeNode current = root;
		TreeNode node = new TreeNode(val);

		while(true) {
			if(current.val < val) {
				if(null == current.right) {
					current.right = node; 
					break;
				}
				else current = current.right;
			} else {
				if(null == current.left) {
					current.left = node; 
					break;
				}
				else current = current.left;
			}
		}

		return root;
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
