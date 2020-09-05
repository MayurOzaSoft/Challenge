package com.study.september.week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * All Elements in Two Binary Search Trees
 *
 * Given two binary search trees root1 and root2.
 *
 * Return a list containing all the integers from both trees sorted in ascending order.
 *
 *  Example 1:
 *
 * Input: root1 = [2,1,4], root2 = [1,0,3]
 * Output: [0,1,1,2,3,4]
 *
 * Example 2:
 *
 * Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * Output: [-10,0,0,1,2,5,7,10]
 *
 * Example 3:
 *
 * Input: root1 = [], root2 = [5,1,7,0,2]
 * Output: [0,1,2,5,7]
 *
 * Example 4:
 *
 * Input: root1 = [0,-10,10], root2 = []
 * Output: [-10,0,10]
 *
 * Example 5:
 *
 * Input: root1 = [1,null,8], root2 = [8,1]
 * Output: [1,1,8,8]
 *
 *
 * Constraints:
 *
 * Each tree has at most 5000 nodes.
 * Each node's value is between [-10^5, 10^5].
 *
 */
public class Solution5 {
    public List<Integer> getAllElements_17ms(TreeNode root1, TreeNode root2) {
        List<Integer> root_1_list = new ArrayList<>();
        List<Integer> root_2_list = new ArrayList<>();

        traverseTree(root1, root_1_list);
        traverseTree(root2, root_2_list);

        root_1_list.addAll(root_2_list);

        Collections.sort(root_1_list);

        return root_1_list;

    }

    public void traverseTree(TreeNode root, List<Integer> rootList){
        if(root == null) return;

        rootList.add(root.val);
        traverseTree(root.left, rootList);
        traverseTree(root.right, rootList);
    }

    /**
     * Definition for a binary tree node.
     *
     * */
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

    public List<Integer> getAllElements_5ms(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> tree = new LinkedList<>();
        LinkedList<Integer> merged = new LinkedList<>();

        inorder(root1, tree);
        merge(root2, merged, tree);

        merged.addAll(tree);

        return merged;
    }

    private void inorder(TreeNode node, LinkedList<Integer> tree) {
        if (node == null) return;

        inorder(node.left, tree);
        tree.add(node.val);
        inorder(node.right, tree);
    }

    private void merge(TreeNode node, LinkedList<Integer> merged, LinkedList<Integer> tree) {
        if (node == null) return;

        merge(node.left, merged, tree);

        while (!tree.isEmpty() && tree.peek() < node.val) {
            merged.add(tree.poll());
        }

        merged.add(node.val);

        merge(node.right, merged, tree);
    }
}
