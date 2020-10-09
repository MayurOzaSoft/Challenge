package com.study.october.week2;

/**
 * Serialize and Deserialize BST
 *
 * Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.
 *
 * The encoded string should be as compact as possible.
 *
 * Example 1:
 *
 * Input: root = [2,1,3]
 * Output: [2,1,3]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * 0 <= Node.val <= 104
 * The input tree is guaranteed to be a binary search tree.
 *
 */
public class Solution9 {
    /**
     * Definition for a binary tree node.
     * */
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public class Codec {

        int index = 0;
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {

            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }
        private void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) return;
            sb.append( (char) (root.val));
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            index = 0;
            return deserialize(data, Integer.MIN_VALUE, Integer.MAX_VALUE);

        }
        public TreeNode deserialize(String data, int min, int max) {
            if (index == data.length()) return null;
            int x = data.charAt(index);
            if (x < min || x> max) return null;
            index++;
            TreeNode node = new TreeNode(x);
            node.left = deserialize(data, min, x);
            node.right = deserialize(data, x, max);
            return node;
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // String tree = ser.serialize(root);
    // TreeNode ans = deser.deserialize(tree);
    // return ans;
}
