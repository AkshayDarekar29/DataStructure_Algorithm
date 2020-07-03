package stack.NextGreaterElement_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement_2 {
	public static void main(String[] args) {
		NextGreaterElement_2 obj = new NextGreaterElement_2();
		int [] nums1 = {5,4,3,2,1};
		int [] arr = obj.nextGreaterElements(nums1);
		System.out.println(Arrays.toString(arr));
	}
	/*
	 * Approach 1 : Using Stack
	 * Time Complexity: O(n2)
	 * Space Complexity: O(n)
	 */
	
	public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
         int[] ind = new int[nums.length];
         for(int i=0; i<ind.length; i++){
        	 	ind[i] = -1;
         }
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<nums.length; i++){
            while(!stack.empty() && nums[stack.peek()] < nums[i]){
                ind[stack.pop()] = i;
            }
            stack.push(i);
        }
        while(!stack.empty()){
        	int elementPos = stack.pop();
        	for(int i=0; i< elementPos; i++){
        		if(nums[i] > nums[elementPos]){
        			ind[elementPos] = i;
        			break;
        		}
        	}
        }
        for(int i=0; i<nums.length; i++){
           if(ind[i] != -1){
               res[i] = nums[ind[i]]; 
           }else{
        	   res[i] = -1;
           }
        }
        return res;
    }
}
