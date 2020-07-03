package greedy.Seats;

import java.util.ArrayList;

public class Seats {
	
	/* Approach : Storing positions of each x then finding mid of list
	 * Time Complexity : O(n)
	 * Space Complexity : O(n)
	 */
	public int seats(String A) {
        int MOD = 10000003;
        ArrayList<Integer> l = new ArrayList<>();
        for(int i=0; i<A.length(); i++){
            if(A.charAt(i) == 'x'){
                l.add(i);
            }
        }
        if(l.size() == 0 || l.size() == 1){
            return 0;
        }
        int median = l.size()/2;
        int minJumps = 0;
        for(int i=0; i < l.size(); i++){
            minJumps = (minJumps + Math.abs(l.get(i)-l.get(median))- Math.abs(i-median))%MOD;
        }
        return minJumps;
    }
}
