package com.stack;

class TwoStacks { 
    int cap; 
    int top1, top2; 
    int arr[]; 
  
    TwoStacks(int n) 
    { 
        arr = new int[n]; 
        cap = n; 
        top1 = -1; 
        top2 = cap; 
    } 
  
    void push1(int x) 
    { 
        if (top1 < top2 - 1) { 
            top1++; 
            arr[top1] = x; 
        } 
        else { 
            System.out.println("Stack Overflow"); 
            System.exit(1); 
        } 
    } 
  
    void push2(int x) 
    { 
        if (top1 < top2 - 1) { 
            top2--; 
            arr[top2] = x; 
        } 
        else { 
            System.out.println("Stack Overflow"); 
            System.exit(1); 
        } 
    } 
    
    int pop1() 
    { 
        if (top1 >= 0) { 
            int x = arr[top1]; 
            top1--; 
            return x; 
        } 
        else { 
            System.out.println("Stack Underflow"); 
            System.exit(1); 
        } 
        return 0; 
    } 
  
    int pop2() 
    { 
        if (top2 < cap) { 
            int x = arr[top2]; 
            top2++; 
            return x; 
        } 
        else { 
            System.out.println("Stack Underflow"); 
            System.exit(1); 
        } 
        return 0; 
    }
    
    
}
