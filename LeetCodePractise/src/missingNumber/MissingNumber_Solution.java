package missingNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber_Solution {

	public static void main(String[] args) {
		MissingNumber_Solution obj = new MissingNumber_Solution();
		int [] arr = {9,6,4,2,3,5,7,8,1};
		System.out.println(obj.missingNumber_4(arr));
	}
	
	
	/*Approach 1 : Guass's Formula - My solution when I tried first time
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	*/
	public int missingNumber_1(int[] nums) {
        int max = 0;
        int sum = 0;
        boolean zeroFlag = false;
        for(int i=0; i< nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
            if(nums[i] == 0){
                zeroFlag = true;
            }
            sum = sum + nums[i];
        }
        int expSum = max*(max+1)/2;
        if(max == 0){
            return 1;
        }else if(zeroFlag && (expSum == sum)  ){
            return max + 1;
        }
         return expSum - sum;
    }
	
	/*Approach 2 : Sorting
	 * 
	 * Time Complexity: O(nLog(n))
	 * Space Complexity: O(1)
	*/
	
	public int missingNumber_2(int[] nums) {
        Arrays.sort(nums);

        // Ensure that n is at the last index
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        // Ensure that 0 is at the first index
        else if (nums[0] != 0) {
            return 0;
        }

        // If we get here, then the missing number is on the range (0, n)
        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i-1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }
        // Array was not missing any numbers
        return -1;
    }
	
	/*Approach 3 : using hashset
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	*/
	public int missingNumber_3(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums){
        	numSet.add(num);
        }
        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
	 }
	
	/*Approach 4 : XOR
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	*/
	public int missingNumber_4(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
