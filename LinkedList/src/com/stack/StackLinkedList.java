package com.stack;

class Node{
	int data;
	Node next;
	
	public Node(int d) {
		data = d;
		next = null;
	}
}
public class StackLinkedList {
	Node head;
	int size;
	public StackLinkedList() {
		head = null;
		size = 0;
	}
	int size() {
		return size;
	}
	boolean isEmpty() {
		return head == null;
	}
	
	void push(int data) {
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
		size++;
	}
	int pop() {
		if(isEmpty() == true) {
			return Integer.MAX_VALUE;
		}
		int res = head.data;
		head = head.next;
		size--;
		return res;
	}
	int peek() {
		if(isEmpty() == true) {
			return Integer.MAX_VALUE;
		}
		return head.data;
	}
}
