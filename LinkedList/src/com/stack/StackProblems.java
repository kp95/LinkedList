package com.stack;

import java.util.ArrayDeque;
import java.util.Stack;

public class StackProblems {

	public static void main(String[] args) {
		System.out.println("Stack");
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
	public static int getMaxArea(int arr[],int n){
        Stack <Integer> s=new Stack<>();
        int res=0;
        int tp;
        int curr;
        for(int i=0;i<n;i++){
            while(s.isEmpty()==false && arr[s.peek()]>=arr[i]){
                tp=s.peek();s.pop();
                curr=arr[tp]* (s.isEmpty() ? i : i - s.peek() - 1);
                res=Math.max(res,curr);
            }
            s.add(i);
        }
        while(s.isEmpty()==false){
            tp=s.peek();s.pop();
            curr=arr[tp]* (s.isEmpty() ? n : n - s.peek() - 1);
            res=Math.max(res,curr);
        }
        
        return res;
    
    }
}
