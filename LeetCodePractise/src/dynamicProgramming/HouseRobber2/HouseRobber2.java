package dynamicProgramming.HouseRobber2;

public class HouseRobber2 {
	
	//This problem is same as House Robber I. Please check the solution
	/*Approach 1 : Iterative + 2 Variables
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	/* the order is: prev2, prev1, num  */
	public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    public int rob(int[] nums, int lo, int hi){
	    int prev1 = 0;
	    int prev2 = 0;
	    for (int i = lo; i <= hi; i++) {
	        int tmp = prev1;
	        prev1 = Math.max(prev2 + nums[i], prev1);
	        prev2 = tmp;
	    }
	    return prev1;
    }
}
