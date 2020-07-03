package stack.NextGreaterElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
	public static void main(String[] args) {
		NextGreaterElement obj = new NextGreaterElement();
		int [] nums1 = {4,1,2};
		int [] nums2 = {1,3,4,2};
		int [] arr = obj.nextGreaterElement_2(nums1, nums2);
		System.out.println(Arrays.toString(arr));
	}
	/*
	 * Approach 1 : Brute-Force
	 * Time Complexity: O(n2) 
	 * Space Complexity: O(1)
	 */
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for(int i=0; i<nums1.length;i++){
           boolean flag = false;
            for(int j=0; j<nums2.length;j++){
                if(nums1[i] == nums2[j]){
                    flag = true;
                }
                if(flag && nums2[j] > nums1[i] ){
                    nums1[i] = nums2[j];
                    break;
                }
                if(j == nums2.length-1){
                    nums1[i] = -1;
                }
            }
        }
        return nums1;
    }
	
	/*
	 * Approach 2 : Using Stack
	 * Time Complexity: O(n) 
	 * Space Complexity: O(n)
	 */
	public int[] nextGreaterElement_2(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int n : nums2){
            while(!stack.empty() && stack.peek() < n){
                hm.put(stack.pop(), n);
            }
            stack.push(n);
        }
        for(int i = 0; i<nums1.length; i++){
            nums1[i] = hm.getOrDefault(nums1[i],-1);
        }
        return nums1;
    }
}
