package graph.FlowerPlantingWithNoAdjacent;

import java.util.ArrayList;
import java.util.Arrays;

public class FlowerPlantingWithNoAdjacent {
	
	/* Approach 1 : Greedily coloring graph
	 * Time Complexity : O(V+E), where E is number of edges
	 * Space Complexity : O(V+E)
	 */
	public int[] gardenNoAdj(int N, int[][] paths) {
        ArrayList<Integer> [] graph = new ArrayList[N+1];
        for(int i = 1; i <=N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] a : paths){
            graph[a[0]].add(a[1]);
            graph[a[1]].add(a[0]);
        }
        
        int[] res = new int[N];
        boolean[] available = new boolean[5];
        Arrays.fill(available, true);
        for(int i = 0; i < N; i++){
            ArrayList<Integer> neighbour = graph[i+1];
            for(int n : neighbour){
                if(res[n-1] != 0){
                    available[res[n-1]] = false;
                }
            }
            int color;
            for(color = 1;  color <=4; color++){
                if(available[color]){
                    break;
                }
            }
            res[i] = color;
            Arrays.fill(available, true);
        }
        return res;
    }
}
