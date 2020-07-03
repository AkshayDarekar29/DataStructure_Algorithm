package greedy.JumpGame_2;


public class JumpGame_2 {
	public static void main(String[] args) {
		JumpGame_2 obj = new JumpGame_2();
		int [] nums = {2,3,1,1,3,5,1,0,3};
		int jumps = obj.jump(nums);
		System.out.println(jumps);
	}
	/* Approach 1: 
	 * Time Complexity : O(n)
	 * Space Complexity : O(1)
	 */
	public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if(curFarthest >= nums.length-1){
                break;
            }else if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps+1;
	}
}
