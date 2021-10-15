package com.linkedlist.single;

public class Node {

	int data;
	Node next;
	
	public Node(int x) {
		this.data = x;
		next = null;
	}
	
}

class Test{
	
		public static Node list;
	public static void main(String[] args) {
		list = new Node(10);
		Node temp1 = new Node(20);
		Node temp2 = new Node(30);
		
		list.next = temp1;
		temp1.next = temp2;
		
		//printList(head);
		insetAtBeginging(40);
		insetAtEnd(50);
		//DeleteAtEnd();
		InsertAtKPost(60, 8);
		printListRecursive(list);
		System.out.println("Position :: "+search(30));
		System.out.println("Position Recursive :: " + searchRecursive(list, 60, 1));
	}
	
	public static void printList(Node head) {
		Node curr = head;
		while(curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
	
	public static void printListRecursive(Node head) {
		if(head == null) {
			return ;
		}
		System.out.println(head.data);
		printListRecursive(head.next);
	}
	
	public static void insetAtBeginging(int data) {
		Node newNode =  new Node(data);
		newNode.next = list;
		list = newNode;
	}
	public static void insetAtEnd(int data) {
		Node newNode =  new Node(data);
		Node curr = list;
		while(curr.next != null) {
			curr  = curr.next;
		}
		curr.next = newNode;
		
	}
	public static void DeletAtFirst() {
		if(list == null) {
			return;
		}
		Node newNode =  list.next;
		list = newNode;
	}
	public static void DeleteAtEnd() {
		if(list == null || list.next == null) return;
		Node curr = list;
		while(curr.next.next != null) {
			curr  = curr.next;
		}
		curr.next = null;		
	}
	public static void InsertAtKPost(int data, int pos) {
		Node curr = list;
		int count = 1;
		if(pos == 1) {
			insetAtBeginging(data);
			return;
		}
		while(count != pos -1 && curr.next != null) {
			count ++;
			if(count == pos)return;
			
			curr = curr.next;
		}
		Node newNode = new Node(60);
		newNode.next = curr.next;
		curr.next = newNode;
		
	}
	
	public static int search(int item) {
		Node curr = list;
		int count = 1;
		while(curr != null) {
			if(curr.data == item) {
				return count;
			}
			count++;
			curr = curr.next;
		}
		return -1;
	}
	public static int searchRecursive(Node tempList,int item,int count) { 
		if(tempList.data == item) {
			return count;
		}
		return searchRecursive(tempList.next, item, count+1);
	}
	
}