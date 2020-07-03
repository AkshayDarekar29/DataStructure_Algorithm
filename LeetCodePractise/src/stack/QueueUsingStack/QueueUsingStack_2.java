package stack.QueueUsingStack;

import java.util.Stack;

/*
 * Approach 1: All operations using (1) except pop - O(1)
 */
class QueueUsingStack_2 {		
    	Stack<Integer> s1 = new Stack<>();
	    Stack<Integer> s2 = new Stack<>();
	    Integer first = null;
	    public QueueUsingStack_2() {}
	    
	    public void push(int x) {
	        if(s1.empty()){
	            first = x;
	        }
	        s1.push(x);
	    }
	    
	    public int pop() {
	        if(s2.empty()){
	        	while (!s1.isEmpty()){
	                s2.push(s1.pop());
	        	}
	        }
	        return s2.pop();     
	    }
	    
	    public int peek() {
            if (!s2.isEmpty()) {
                return s2.peek();
            }
	        return first;   
	    }
	    
	    public boolean empty() {
	        return s1.isEmpty() && s2.isEmpty();
	    }
}