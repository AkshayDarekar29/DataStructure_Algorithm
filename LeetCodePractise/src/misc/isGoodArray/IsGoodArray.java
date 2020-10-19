package misc.isGoodArray;

public class IsGoodArray {
	public static void main(String[] args) {
		IsGoodArray obj = new IsGoodArray();
	}
	/*
	 * Time Complexity : O(n)
	 * Space Complexity : O(n)
	 *https://massivealgorithms.blogspot.com/2020/01/leetcode-1250-check-if-it-is-good-array.html
	*/
	public boolean isGoodArray(int[] nums) {
        int x = nums[0];
        int y;
        for (int i = 1; i < nums.length; i++) {
            int a = nums[i];
            while(a > 0) {
                y = x % a;
                x = a;
                a = y;
            }
            if (x == 1) return true;
        }
        return x == 1;
    }
}
