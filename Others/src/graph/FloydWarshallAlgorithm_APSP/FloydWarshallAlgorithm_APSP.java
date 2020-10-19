package graph.FloydWarshallAlgorithm_APSP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FloydWarshallAlgorithm_APSP {
	
	public static void main(String[] args) {
		FloydWarshallAlgorithm_APSP obj = new FloydWarshallAlgorithm_APSP();
		int n = 7;
		double[][] m = obj.createGraph(n);
	  	m[0][1] = 2;
	    m[0][2] = 5;
	    m[0][6] = 10;
	    m[1][2] = 2;
	    m[1][4] = 11;
	    m[2][6] = 2;
	    m[6][5] = 11;
	    m[4][5] = 1;
	    m[5][4] = -2;
	    double [][] shortestDistance = obj.shortestPathByBellman(m);
	    for(double[] d : shortestDistance){
	    	System.out.println(Arrays.toString(d));
	    }
	    System.out.println();
	    
	    for(int[] d : obj.next){
	    	System.out.println(Arrays.toString(d));
	    }
	}
	
	/* Approach 1 : Floyd Warshall Algorithm
	 * Time Complexity : O(V^3), where E is number of Edges
	 * Space Complexity : O(V^2), where V is number of Vertices
	 */
	int [][] next;
	double dp[][];
	private double[][] shortestPathByBellman(double[][] m) {
		setUpMatrix(m);
		int n = m.length;
		for (int k = 0; k < n; k++) {
	      for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	          if (dp[i][k] + dp[k][j] < dp[i][j]) {
	            dp[i][j] = dp[i][k] + dp[k][j];
	            next[i][j] = next[i][k];
	          }
	        }
	      }
	    }
		
		for (int k = 0; k < n; k++){
		      for (int i = 0; i < n; i++){
		        for (int j = 0; j < n; j++){
		          if (dp[i][k] + dp[k][j] < dp[i][j]) {
		            dp[i][j] = Double.NEGATIVE_INFINITY;
		            next[i][j] = -1;
		          }
				}
			}
		}	
		
		return dp;
	}

	public List<Integer> reconstructShortestPath(int start, int end) {
	    List<Integer> path = new ArrayList<>();
	    if (dp[start][end] == Double.POSITIVE_INFINITY){
	    	return path;
	    }
	    int at;
	    for (at = start; at != end; at = next[at][end]) {
	      if (at == -1){
	    	  return null;
	      }
	      path.add(at);
	    }
	    if (next[at][end] == -1){
	    	return null;
	    }
	    path.add(end);
	    return path;
	 }
	
	private void setUpMatrix(double[][] m) {
		int n = m.length;
		next = new int[n][n];
		dp = new double[n][n];
		for(int i=0; i<n;i++){
			for(int j=0; j<n; j++){
				if(m[i][j] != Double.POSITIVE_INFINITY){
					next[i][j] = j;
				} 
				dp[i][j] = m[i][j];
			}
		}
	}

	public double[][] createGraph(int n){
		double[][] m = new double[n][n];
		for(int i=0; i < n; i++){
			Arrays.fill(m[i], Double.POSITIVE_INFINITY);
			m[i][i] = 0;
		}
		return m;
	}
}

	
	

