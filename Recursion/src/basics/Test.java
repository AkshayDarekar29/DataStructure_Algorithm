package basics;

public class Test {
	public static void main(String[] args) {
		System.out.println("Main Start");
		foo(4);
		System.out.println("Main End");
	}

	private static void foo(int i) {
		if(i < 1){
			return;
		}else{
			//--i;
			//foo(--i);
			//foo(i--);
			foo(i-1);
			System.out.println("Hello World - "+ i);
		}
	}
}
