package arrays.containerWithMostWater;

public class ContainerWithMostWater {
	
	/*
	 * Approach : Two Pointers
	 * Time Complexity: O(n)
	 *  Space Complexity: O(1)
	 */
	public int maxArea(int[] height) {
        int x = 0;
        int y = height.length - 1;
        int max = 0;
        while(x < y){
            int tempHeight = Math.min(height[x], height[y]);
            int tempMax = (y-x)*tempHeight;            
            max = Math.max(max, tempMax);
            
            if(height[y] > height[x]){
                x++;
            }else{
                y--;
            }
        }
        return max;
    }
}
