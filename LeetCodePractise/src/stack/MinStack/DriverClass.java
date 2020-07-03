package stack.MinStack;

public class DriverClass {
	public static void main(String[] args) {
		MinStack_2 stack = new MinStack_2();
		stack.push(4);
		System.out.println("Min - " +stack.getMin());
		stack.push(5);
		System.out.println("Min - " +stack.getMin());
		stack.push(3);
		System.out.println("Min - " +stack.getMin());
		stack.push(0);
		System.out.println("Min - " +stack.getMin());
		stack.push(1);
		System.out.println("Min - " +stack.getMin());
		stack.push(6);
		System.out.println("Min - " +stack.getMin());
		stack.push(7);
		System.out.println("Min - " +stack.getMin());
		stack.pop();
		System.out.println("Min - " +stack.getMin());
		stack.pop();
		System.out.println("Min - " +stack.getMin());
		stack.pop();
		System.out.println("Min - " +stack.getMin());
		stack.pop();
		System.out.println("Min - " +stack.getMin());
		stack.pop();
		System.out.println("Min - " +stack.getMin());
		stack.pop();
		System.out.println("Min - " +stack.getMin());
	
	}
}
