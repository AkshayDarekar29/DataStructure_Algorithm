package greedy.BoatsToSavePeople;

import java.util.Arrays;

public class BoatsToSavePeople {
	
	/* Approach 1: 
	 * Time Complexity : O(nLog(n))
	 * Space Complexity : O(1)
	 */
	public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int start = 0; 
        int end = people.length-1;
        int w = 0;
        int result = 0;
        int count = 0;
        while(end >= start){
            while(count < 2 && end >=0 && w + people[end] <= limit){
                w = w + people[end];
                count++;
                end--;
            }
            while(count < 2 && start < people.length && w + people[start] <= limit){
                w = w + people[start];
                count++;
                start++;
            }
            result++;
            w = 0;
            count = 0;
        }
        return result;
    }
}
