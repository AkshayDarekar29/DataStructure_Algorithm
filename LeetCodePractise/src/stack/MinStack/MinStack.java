package stack.MinStack;

import java.util.Stack;

/*
 * Approach 1 - adding min element to same stack based on a condition
 * Time Complexity - O(1)
 * Space Complexity - O(1)
 */
public class MinStack {
	int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public int pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
    	int x = stack.pop();
        if(x == min) {
        	min=stack.pop();
        }
        return x;
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
