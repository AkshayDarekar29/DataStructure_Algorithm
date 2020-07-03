package stack.QueueUsingStack;

import java.util.Stack;

/*
 * Approach 1: All operations using (1) except pop - O(n)
 */
class QueueUsingStack {
	 Stack<Integer> s1 = new Stack<>();
	    Stack<Integer> s2 = new Stack<>();
	    Integer first = null;
	    public QueueUsingStack() {}
	    
	    public void push(int x) {
	        if(first == null){
	            first = x;
	        }
	        s1.push(x);
	    }
	    
	    public int pop() {
	        while(s1.size()>1){
	            first = s1.pop();
	            s2.push(first);
	        }
	        int x = s1.pop();
	        while(!s2.empty()){
	            s1.push(s2.pop());
	        }
	        if(s1.empty()){
	            first = null;
	        }
	        return x;
	        
	    }
	    
	    public int peek() {
	        return first;   
	    }
	    
	    public boolean empty() {
	        return s1.size() == 0;
	    }
}