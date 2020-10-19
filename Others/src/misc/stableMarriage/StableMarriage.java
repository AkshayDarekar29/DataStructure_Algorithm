package misc.stableMarriage;

import java.util.Arrays;

public class StableMarriage {
	public static void main(String[] args) {
		StableMarriage obj = new StableMarriage();
		int prefer[][] = new int[][]{{7, 5, 6, 4},  
            {5, 4, 6, 7},  
            {4, 5, 6, 7},  
            {4, 5, 6, 7},  
            {0, 1, 2, 3},  
            {0, 1, 2, 3},  
            {0, 1, 2, 3},  
            {0, 1, 2, 3}};  
            int[] womenToMen = obj.stableMarriage(prefer);  
            System.out.println(Arrays.toString(womenToMen));
	}
	
	/*
	 * Approach : Gale–Shapley algorithm 
	 * Time Complexity : O(n2)
	 * Space Complexity : O(n)
	 * https://www.geeksforgeeks.org/stable-marriage-problem/
	*/
	public int[] stableMarriage(int[][] prefer) {
		int N = prefer.length/2;
		int[] women = new int[N];
		Arrays.fill(women, -1);
		boolean[] menFree = new boolean[N];
		int freeCount = N;
		
		while(freeCount > 0){
			int m;
			for(m=0; m < N; m++){
				if(menFree[m] == false){
					break;
				}
			}
			
			for(int i=0; i < N && menFree[m] == false; i++){
				int w = prefer[m][i];
				if(women[w-N] == -1){
					women[w-N] = m;
					menFree[m] = true;
					freeCount--;
				}else{
					int m1 = women[w-N];
					if(wPrefersM1OverM(prefer, w, m1, m) == false){
						women[w - N] = m;
						menFree[m1] = false;
						menFree[m] = true;
					}
				}
			}
		}
		return women;
	}

	public boolean wPrefersM1OverM(int[][] prefer, int w, int m1, int m) {
		for(int i=0; i< prefer.length/2; i++){
			if(prefer[w][i] == m1){
				return true;
			}
			if(prefer[w][i] == m){
				return false;
			}
		}
		return false;
	}
	
}
