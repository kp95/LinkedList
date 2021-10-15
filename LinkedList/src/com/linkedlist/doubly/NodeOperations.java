package com.linkedlist.doubly;

public class NodeOperations {

	static Node doublyList;
	public static void main(String[] args) {
		doublyList = new Node(10);
		
		Node temp1 = new Node(20);
		Node temp2 = new Node(30);
		
		doublyList.next = temp1;
		
		temp1.prev = doublyList;
		temp1.next = temp2;
		
		temp2.prev = temp1;
		insertAtBegin(60);
		reverseTraverse();
		
	}
	public static void traverse() {
		Node curr = doublyList;
		while(curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
	
	public static void insertAtBegin(int data) {
		Node newNode = new Node(data);
		newNode.next = doublyList;
		doublyList.prev = newNode;
		newNode.prev = null;
		doublyList = newNode;
	}
	public static void reverseTraverse() {
		Node curr = doublyList;
		while(curr.next != null) {
			curr = curr.next;
		}
		while(curr != null) {
			System.out.println(curr.data);
			curr = curr.prev;
		}
	}
	public static void reverseList() {
		Node curr = doublyList;
		Node prev;
		while(curr != null) {
			prev = curr.prev;
			curr.prev = curr.next;
			curr.next = prev;
			curr = curr.prev;
		}
		
	}
	
	
	
}
