package stack.NearestSmallerElement;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement {
	/*Approach 1 : Using Stack and Array
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	*/
	public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        int [] arr = new int[A.size()];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = A.size()-1; i >= 0; i--){
            while(!stack.empty()  && A.get(stack.peek()) > A.get(i)){
                arr[stack.pop()] = i;
            }
            stack.push(i);
        }
        while(!stack.empty()){
            arr[stack.pop()] = -1;
        }
        for(int i = 0; i < A.size(); i++){
            if(arr[i] != -1){
                res.add(A.get(arr[i]));
            }else{
                res.add(-1);
            }
        }
        return res;
    }
}
