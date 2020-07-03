package arrays.rearrangeArray;

import java.util.ArrayList;

public class RearrangeArray {
	public static void main(String[] args) {
		RearrangeArray obj = new RearrangeArray();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(0);
		list.add(2);
		list.add(1);
		list.add(4);
		list.add(6);
		list.add(3);
		System.out.println(list.toString());
		obj.arrange(list);
		System.out.println(list.toString());

	}
	/*Approach 1 : Math
	 * 			1) Increase every Array element Arr[i] by (Arr[Arr[i]] % n)*n.
	 *	    	2) Divide every element by n
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	*/
	public void arrange(ArrayList<Integer> A) {
	   	int n = A.size();
	    for (int i = 0; i < n; i++) {
	    	A.set(i, A.get(i) + (A.get(A.get(i)) % n) * n );
	    }
	    for (int i = 0; i < n; i++) {
	    	A.set(i, A.get(i) / n);
	    }
	}
}
