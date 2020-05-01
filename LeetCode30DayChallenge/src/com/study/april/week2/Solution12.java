package com.study.april.week2;

/**
 * Min Stack
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * 
 * pop() -- Removes the element on top of the stack.
 * 
 * top() -- Get the top element.
 * 
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution12 {
	
	class MinStack {

		Node head;

		private class Node {
			int value;
			int min;
			Node next;

			public Node(int value, int min, Node next) {
				this.value = value;
				this.min = min;
				this.next = next;
			}

		}

		public MinStack() {

		}

		public void push(int x) {
			if (head == null) {
				head = new Node(x, x, null);
			} else {
				head = new Node(x, Math.min(x, head.min), head);
			}
		}

		public void pop() {
			head = head.next;
		}

		public int top() {
			return head.value;
		}

		public int getMin() {
			return head.min;
		}
	}
}
