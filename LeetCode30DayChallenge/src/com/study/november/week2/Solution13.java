package com.study.november.week2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Populating Next Right Pointers in Each Node
 *
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Follow up:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 *
 * Constraints:
 *
 * The number of nodes in the given tree is less than 4096.
 * -1000 <= node.val <= 1000
 *
 */
public class Solution13 {

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root){
        return populateNode_0ms(root, null);
    }

    private Node populateNode_0ms(Node root, Node neighbour) {
        if(root == null) return null;

        root.next = neighbour;
        populateNode_0ms(root.left, root.right);
        populateNode_0ms(root.right, neighbour == null ? null : neighbour.left);

        return root;
    }

    public Node connect_2ms(Node root) {
        if (root == null) return root;
        if (root.left == null && root.right == null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        Node prev = null;

        while (!queue.isEmpty()) {

            Node current = queue.remove();

            if (prev != null)
                prev.next = current;

            if (current == null) {
                if (!queue.isEmpty())
                    queue.add(null);

            } else {
                if (current.left != null)
                    queue.add(current.left);

                if (current.right != null)
                    queue.add(current.right);
            }

            prev = current;

        }

        return root;
    }
}
