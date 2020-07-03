package stack.StackUsingQueue;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Approach 1 : All operations using O(1) except pop - O(n)
 */
public class StackUsingQueue_2 {
	
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    int top;
    public StackUsingQueue_2() {
        
    }

    public void push(int x) {
        q1.add(x);
        top = x;
    }
    
    public int pop() {
        while(q1.size()>1){
            top = (Integer)q1.remove();
            q2.add(top);
        }
        int popedElement = (Integer)q1.remove();
        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;
        
        return popedElement;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        if(q1.isEmpty()){
            return true;
        }
        return false;
    }
}
