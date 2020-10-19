package graph.TravellingSalesmanProblem_BruteForce;

import java.util.ArrayList;
import java.util.List;

public class TravellingSalesmanProblem_BruteForce {
	
	public static void main(String[] args) {
		int graph[][] = { { 0, 10, 15, 20 }, 
		                { 10, 0, 35, 25 }, 
		                { 15, 35, 0, 30 }, 
		                { 20, 25, 30, 0 } };
	    TravellingSalesmanProblem_BruteForce obj = new TravellingSalesmanProblem_BruteForce();
	    int minCost = obj.getMinCost(graph);
	    System.out.println(minCost);
	    for(int i=0; i < obj.minCostCycle.size(); i++){
	    	if(i == 0){
	    		System.out.print("0"+ " --> " + obj.minCostCycle.get(i));
	    	}else if(i == obj.minCostCycle.size()-1){
	    		System.out.println(obj.minCostCycle.get(i));
	    	}else{
	    		System.out.print(" --> " +  obj.minCostCycle.get(i) + " --> " );
	    	}
	    }
	}

	/* Approach 1 : 
	 * Time Complexity : O(n!), where E is number of Edges
	 * Space Complexity : 
	 */
	List<Integer> minCostCycle;
	private int getMinCost(int[][] graph) {
		int numberOfVertices = graph.length;
		int minCost = Integer.MAX_VALUE;
		int [] vertices = new int[numberOfVertices-1];
		for(int i=1; i < numberOfVertices;  i++){
			vertices[i-1] = i;
		}
		List<List<Integer>> permutations = permute(vertices);
		for(int i=0; i < permutations.size(); i++){
			List<Integer> cycle = permutations.get(i);
			int cost = 0;
			int prev = 0;
			for(int j=0; j < cycle.size(); j++){
				if(j == 0){
					cost = cost + graph[0][cycle.get(j)];
				}else{
					cost = cost + graph[prev][cycle.get(j)];
				}
				prev = cycle.get(j);
			}
			cost = cost + graph[prev][0];
			if(cost < minCost){
				minCost = cost;
				minCostCycle = cycle;
			}
		}
		return minCost;
	}
	
	public List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        permuteNew(nums, 0, nums.length-1);
        return list;
    }
    
    public void permuteNew(int[] nums, int l, int r) {
        if(l == r){
            List<Integer> temp = new ArrayList<Integer>(nums.length);
            for (int i : nums)
            {
                temp.add(i);
            }
            list.add(temp);
        }else{
           for(int i = l; i <= r; i++){
               swap(nums, l, i);
               permuteNew(nums, l+1, r);
               swap(nums, l, i);
           }
        }       
    }
    
    public void swap(int [] input, int l, int i){
        int temp = input[l];
        input[l] = input[i];
        input[i] = temp;
    }
}