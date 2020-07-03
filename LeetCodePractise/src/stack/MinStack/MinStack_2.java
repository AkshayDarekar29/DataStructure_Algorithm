package stack.MinStack;

import java.util.Stack;

/*
 * Approach 2 - Creating stack for minimum values
 * Time Complexity - O(1)
 * Space Complexity - O(n)
 */
public class MinStack_2 {
	 Stack<Integer> stack = new Stack<>();
	    Stack<Integer> minStack = new Stack<>(); // keeps track of minimums

	    // Always push onto stack. If it's a minimum, also push it onto minStack
	    public void push(int x) {
	        stack.push(x);
	        if (minStack.isEmpty() || x <= getMin()) {
	            minStack.push(x);
	        }
	    }

	    // Pop off stack. If we popped a minimum, we remove it from minStack also
	    public void pop() {
	        if (stack.isEmpty()) {
	            return;
	        }
	        int x = stack.pop();
	        if (x == minStack.peek()) {
	            minStack.pop();
	        }
	    }

	    public int top() {
	        return stack.peek();
	    }

	    public int getMin() {
	        return minStack.peek();
	    }
}
