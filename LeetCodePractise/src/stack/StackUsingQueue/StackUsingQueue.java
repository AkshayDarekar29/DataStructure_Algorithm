package stack.StackUsingQueue;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Approach 1 : All operations using O(1)
 */
public class StackUsingQueue {
	
	private Queue<Object> queue = null;
	
    public void push(int x) {
        Queue deeper = queue;
        queue = new LinkedList<Object>();
        queue.add(x);
        queue.add(deeper);
    }
    
    public int pop() {
        int x = (Integer)queue.poll();
        queue = (Queue<Object>)queue.poll();
        return x;
    }
    
    public int top() {
        return (Integer)queue.peek();
    }
    
    public boolean empty() {
        return queue == null;
    }
}
