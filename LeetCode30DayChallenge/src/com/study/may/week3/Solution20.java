package com.study.may.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution20 {

	List<Integer> numbers = new ArrayList<>();

	public int kthSmallest_3ms(TreeNode root, int k) {

		smallestNode_3ms(root, k);

		Collections.sort(numbers);

		return numbers.get(k - 1);
	}

	private void smallestNode_3ms(TreeNode root, int k) {
		if (root == null)
			return;

		numbers.add(root.val);

		smallestNode_3ms(root.left, k);
		smallestNode_3ms(root.right, k);
	}
	
	public int kthSmallest_1ms(TreeNode root, int k) {
        smallestNode(root);
        return numbers.get(k - 1);
    }
    
	/**
	 * In order traversal gives you sorted values in ASC order, makes our work easier
	 * 
	 * @param root
	 */
    private void smallestNode(TreeNode root){
        if(root == null) return;
        
        smallestNode(root.left);
        
        numbers.add(root.val);
        
        smallestNode(root.right);
    }
    
    public int kthSmallest_StackApproach(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        
        while(true){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            
            if(--k == 0) return root.val;
            
            root = root.right;
            
        }
        
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
