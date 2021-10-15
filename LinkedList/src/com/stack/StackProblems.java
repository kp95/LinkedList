package com.stack;

import java.util.ArrayDeque;

public class StackProblems {

	public static void main(String[] args) {
		
	}
	
	public static boolean matching(Character a, Character b) {
		return (
				(a == '(' && b == ')')||
				(a == '{' && b == '}')||
				(a == '[' && b == ']')
				);
	}
	public static boolean isBalanced(String str) {
		ArrayDeque<Character> stack = new ArrayDeque<>();
		
		for(int i = 0;i<str.length();i++) {
			char x = str.charAt(i);
			if(x == '(' || x == '[' || x == '{') {
				stack.push(x);
			}
			else {
				if(stack.isEmpty()) {
					return false;
				}
				else if(matching(x, stack.peek()) ==  false) {
					return false;
				}
				else {
					stack.pop();
				}
			}
		}
		return stack.isEmpty() == true;
	}
}
