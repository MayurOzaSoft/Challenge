package com.study.june.week1;

/**
 * Delete Node in a Linked List
 * 
 * Write a function to delete a node (except the tail) in a singly linked list,
 * given only access to that node.
 * 
 * Given linked list -- head = [4,5,1,9], which looks like following:
 * 
 * Input: head = [4,5,1,9], node = 5
 * 
 * Output: [4,1,9]
 * 
 * Explanation:
 * 
 * You are given the second node with value 5,
 * 
 * the linked list should become 4 -> 1 -> 9 after calling your function.
 * 
 * Note:
 * 
 * The linked list will have at least two elements. All of the nodes' values
 * will be unique.
 * 
 * The given node will not be the tail and it will always be a valid node of the
 * linked list.
 * 
 * Do not return anything from your function.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution2 {

	public void deleteNode(ListNode node) {

		node.val = node.next.val;
		node.next = node.next.next;

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
