package com.stack;
/**
 * Fixed Size Stack
 * 
 * 
 * */
public class MyStack {

	int arr[];
	int cap;
	int top;
	
	public MyStack(int size) {
		// TODO Auto-generated constructor stub
		this.top = -1;
		this.cap = size;
		arr = new int[size];
	}
	void push(int x) {
		if(top == cap -1) {
			//overflow
			System.err.println("Stack is Full");
		}
		top++;
		arr[top] = x;
	}
	int pop() {
		if(top == -1) {
			//under flow
			return Integer.MAX_VALUE;
		}
		int res = arr[top];
		top--;
		return res;
	}
	int peek() {
		if(top == -1) {
			return Integer.MAX_VALUE;
		}
		return arr[top];
	}
}
