package stack.StackImplementationUsingArray;

public class DriverClass {
	public static void main(String[] args) {
		StackImplementationUsingArray<Integer> stack = new StackImplementationUsingArray<>();
		System.out.println(stack.isFull());
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.isFull());
		
		System.out.println(stack.peek());
		//System.out.println(stack.pop());
		stack.push(5);		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		//System.out.println(stack.peak());
	}
}
