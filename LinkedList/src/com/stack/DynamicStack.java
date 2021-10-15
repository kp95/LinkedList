package com.stack;

import java.util.ArrayList;
import java.util.Stack;


public class DynamicStack {
	
	ArrayList<Integer> stack = new ArrayList<>();
	
	void push(int x) {
		stack.add(x);
	}
	int pop() {
		if(stack.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		int res = stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		return res;
	}
	int peek() {
		if(stack.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		return stack.get(stack.size()-1);
	}
	
}
