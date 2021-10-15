package com.linkedlist.single;

import java.util.HashMap;
import java.util.HashSet;

public class ReverseListGroupK {
// reverse a linked list in group of K.
	
	public static Node singleList;
	
	public static void main(String[] args) {
		singleList = new Node(10);
		Node n1 = new Node(20);
		Node n2 = new Node(30);//temp1
		Node n3 = new Node(40);
		Node n4 = new Node(50);
		Node n5 = new Node(60);
		
		singleList.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		//singleList = ReverseInGroupK(singleList, 3);
		//Test.printList(singleList);
		System.err.println(isLoopFlyodWarshall(singleList));
	}
	
	public static Node ReverseInGroupK(Node head, int k) {
		
		Node curr = head, next = null, prev = null;
		
		int count = 1;
		while(curr != null && count <=k) {
			
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		if(next != null) {
			Node rest_head = ReverseInGroupK(next, k);
			head.next = rest_head;
		}
		return prev;
	}
	public static void reverse(Node head) {
		Node curr,next,prev = null;
		curr = head;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		singleList = prev;
	}
	
	//LOOP Detection - add visited flag
	//another method= create dummy node, and change next of every node to dummy node ,if next of any node is dummy node then loop.
	// Use Hashing
	
	
	public static boolean isCycle(Node head) {
		
		//Time- n
		//space - n
		Node curr = head;
		HashSet<Node> visitedSet = new HashSet<>();
		while(curr!= null) {
			if(visitedSet.contains(curr)) {
				return true;
			}
			visitedSet.add(curr);
			curr = curr.next;
		}
		return false;
		
		
	}
	public static boolean isLoopFlyodWarshall(Node head) {
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
	public static boolean removeLoopFlyodWarshall(Node head) {
		// first meeting pint of slow fast is depend on cycle,
		//but second meeting point always will be start of cycle
		
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				break;
			}
		}
		if(slow != fast) {
			return false;
		}
		slow = head;
		while(slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}
		fast.next = null;
		return false;
	}
	//Q-//segaregate linked list in such way alll even appear first the all odd with same order
	//sol- use 4 pointers Evenstart,evenend,oddstart oddend


	//Q?? find interstion point in list;
	//count nodes in both list stroer in c1,c2
	//traverse bigger list abs(c1-c2)
	//traverse both list simultaneously, both pointer meet at intersection ponint.

	
	
	//Q-clone a linked list using random node
	
	//LRU cache design - temporal locality
	//use hashtable and doubly linked list
	//hash table will hold valu and ref to node to list
	//for every input check in hash table- entry is found - hit, get ref from hash table and move that node to front.
	//for miss, check if cahce is full- if yes remove last node from doubly linked list and insert new node in front.
	//for miss if cache is not full, simply add in front of list.
	//link list is used here for recency maintaining order
	
	//Q merge two sorted link list
	static Node sortedMerge(Node a,Node b){
        if(a==null)return b;
        if(b==null)return a;
        Node head=null,tail=null;
        if(a.data<=b.data){
            head=tail=a;a=a.next;
        }
        else{
            head=tail=b;b=b.next;
        }
        while(a!=null&&b!=null){
            if(a.data<=b.data){
                tail.next=a;tail=a;a=a.next;
            }
            else{
                tail.next=b;tail=b;b=b.next;
            }
        }
        if(a==null){tail.next=b;}
        else{
            tail.next=a;
        }
        return head;
    }
	
	
	//check if sngle linked list is palindrome
	//first find the middle of linked list
	//reverse second half
	//now compare one by one from head, reverse head to null
	static Node reverseList(Node head){
        if(head==null||head.next==null)return head;
        Node rest_head=reverseList(head.next);
        Node rest_tail=head.next;
        rest_tail.next=head;
        head.next=null;
        return rest_head;
    }
	static boolean isPalindrome(Node head){
        if(head==null)return true;
        Node slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node rev=reverseList(slow.next);
        Node curr=head;
        while(rev!=null){
            if(rev.data!=curr.data)
                return false;
            rev=rev.next;
            curr=curr.next;
        }
        return true;
    }
}
class CacheNode { 
	int key; 
	int value; 
	CacheNode pre; 
	CacheNode next; 

	public CacheNode(int key, int value) 
	{ 
		this.key = key; 
		this.value = value; 
	} 
} 
class LRUCache { 
	private HashMap<Integer, CacheNode> map; 
	private int capacity, count; 
	private CacheNode head, tail; 

	public LRUCache(int capacity) 
	{ 
		this.capacity = capacity; 
		map = new HashMap<>(); 
		head = new CacheNode(0, 0); 
		tail = new CacheNode(0, 0); 
		head.next = tail; 
		tail.pre = head; 
		head.pre = null; 
		tail.next = null; 
		count = 0; 
	} 

	public void deleteNode(CacheNode node) 
	{ 
		node.pre.next = node.next; 
		node.next.pre = node.pre; 
	} 

	public void addToHead(CacheNode node) 
	{ 
		node.next = head.next; 
		node.next.pre = node; 
		node.pre = head; 
		head.next = node; 
	} 
 
	public int get(int key) 
	{ 
		if (map.get(key) != null) { 
			CacheNode node = map.get(key); 
			int result = node.value; 
			deleteNode(node); 
			addToHead(node); 
			System.out.println("Got the value : " + 
				result + " for the key: " + key); 
			return result; 
		} 
		System.out.println("Did not get any value" + 
							" for the key: " + key); 
		return -1; 
	} 

	public void set(int key, int value) 
	{ 
		System.out.println("Going to set the (key, "+ 
			"value) : (" + key + ", " + value + ")"); 
		if (map.get(key) != null) { 
			CacheNode node = map.get(key); 
			node.value = value; 
			deleteNode(node); 
			addToHead(node); 
		} 
		else { 
			CacheNode node = new CacheNode(key, value); 
			map.put(key, node); 
			if (count < capacity) { 
				count++; 
				addToHead(node); 
			} 
			else { 
				map.remove(tail.pre.key); 
				deleteNode(tail.pre); 
				addToHead(node); 
			} 
		} 
	} 
}