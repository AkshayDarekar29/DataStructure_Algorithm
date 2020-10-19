package graph.BellmanFordAlgorithm_SSSP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BellmanFordAlgorithm_SSSP {
	
	public static void main(String[] args) {
		HashMap<Integer, List<Edge>> graph = new HashMap<>();
		int n = 9;
		for (int i = 0; i < n; i++) {
			graph.put(i, new ArrayList<>());
		}
		
		graph.get(0).add(new Edge(0, 1, 1));
	    graph.get(1).add(new Edge(1, 2, 1));
	    graph.get(2).add(new Edge(2, 4, 1));
	    graph.get(4).add(new Edge(4, 3, -3));
	    graph.get(3).add(new Edge(3, 2, 1));
	    graph.get(1).add(new Edge(1, 5, 4));
	    graph.get(1).add(new Edge(1, 6, 4));
	    graph.get(5).add(new Edge(5, 6, 5));
	    graph.get(6).add(new Edge(6, 7, 4));
	    graph.get(5).add(new Edge(5, 7, 3));
	    
	    BellmanFordAlgorithm_SSSP obj = new BellmanFordAlgorithm_SSSP();
	    double [] shortestDistance = obj.shortestPathByBellman(graph, 0, n);
	    System.out.println(Arrays.toString(shortestDistance));

	}

	/* Approach 1 : Bellman Ford Algorithm
	 * Time Complexity : O(E*V), where E is number of Edges
	 * Space Complexity : O(1), where V is number of Vertices
	 */
	private double[] shortestPathByBellman(HashMap<Integer, List<Edge>> graph, int start, int n) {
		double[] shortestDistance = new double[n];
		Arrays.fill(shortestDistance, Double.POSITIVE_INFINITY);
		shortestDistance[start] = 0;
		for(int i=0; i < n - 1; i++){
			for(int j=0; j < n; j++){
				List<Edge> edgeList = graph.get(j);
				for(Edge e : edgeList){
					if(shortestDistance[j] + e.weight < shortestDistance[e.to]){
						shortestDistance[e.to] = shortestDistance[j] + e.weight;
					}
				}
			}
		}
		
		for(int i=0; i < n - 1; i++){
			for(int j=0; j < n; j++){
				List<Edge> edgeList = graph.get(j);
				for(Edge e : edgeList){
					if(shortestDistance[j] + e.weight < shortestDistance[e.to]){
						shortestDistance[e.to] = Double.NEGATIVE_INFINITY;
					}
				}
			}
		}
		
		return shortestDistance;
	}
}

class Edge{
	int from;
	int to;
	int weight;
	
	public Edge(int from, int to, int weight){
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}

class Node{
	int id;
	int value;
	public Node(int id, int value){
		this.id = id;
		this.value = value;
	}
}