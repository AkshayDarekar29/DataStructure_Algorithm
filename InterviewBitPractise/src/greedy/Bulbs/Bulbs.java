package greedy.Bulbs;

import java.util.ArrayList;

public class Bulbs {
	
	/* Approach : Toggle
	 * Time Complexity : O(n)
	 * Space Complexity : O(1)
	 */
	public int bulbs(ArrayList<Integer> A) {
        
        int res = 0;
        boolean toggle = false;
        for(int i = 0; i < A.size(); i++){
            if((A.get(i) == 1 && !toggle)|| (A.get(i) == 0 && toggle)){
                continue;
            }else{
                res++;
                toggle = !toggle;
            }
        }
        return res;
    }
}
