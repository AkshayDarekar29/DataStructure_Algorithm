package stack.StackImplementationUsingLinkedList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class DriverClass {
	public static void main(String[] args) {
		
		StackImplementationUsingLinkedList<Integer> stack = new StackImplementationUsingLinkedList<>();
		System.out.println(stack.empty());
		stack.push(0);
		stack.push(1);
		System.out.println(stack.peek());
		System.out.println(stack.empty());

		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.empty());

		System.out.println(stack.peek());

	}
}
