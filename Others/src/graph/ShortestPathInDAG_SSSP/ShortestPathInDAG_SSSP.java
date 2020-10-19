package graph.ShortestPathInDAG_SSSP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ShortestPathInDAG_SSSP {
	
	public static void main(String[] args) {
		HashMap<Integer, List<Edge>> graph = new HashMap<>();
		int n = 7;
		for (int i = 0; i < n; i++) {
			graph.put(i, new ArrayList<>());
		}
		
		graph.get(0).add(new Edge(0, 1, 3));
	    graph.get(0).add(new Edge(0, 2, 2));
	    graph.get(0).add(new Edge(0, 5, 3));
	    graph.get(1).add(new Edge(1, 3, 1));
	    graph.get(1).add(new Edge(1, 2, 6));
	    graph.get(2).add(new Edge(2, 3, 1));
	    graph.get(2).add(new Edge(2, 4, 10));
	    graph.get(2).add(new Edge(2, 0, 1));
	    graph.get(3).add(new Edge(3, 4, 5));
	    graph.get(5).add(new Edge(5, 4, 7));
	    
	    ShortestPathInDAG_SSSP obj = new ShortestPathInDAG_SSSP();
	    Integer[] shortestDistance = obj.dagShortestPath(graph, 0, n);
	    System.out.println(Arrays.toString(shortestDistance));
	}

	/* Approach 1 : Using Topological Sort
	 * Time Complexity : O(V+E), where E is number of Edges
	 * Space Complexity : O(V), where V is number of Vertices
	 */
	
	private Integer[] dagShortestPath(HashMap<Integer, List<Edge>> graph, int start, int n) {
		int[] topoSort = topologicalSort(graph, n);
		System.out.println(Arrays.toString(topoSort));
		Integer[] shortestDistance = new Integer[n];
		shortestDistance[start] = 0;
		for(int i=0; i < n; i++){
			int nodeIndex = topoSort[i];
			if(shortestDistance[nodeIndex] != null){
				for(Edge e : graph.get(nodeIndex)){
					int newDistance = shortestDistance[nodeIndex] + e.weight;
					if(shortestDistance[e.to] == null){
						shortestDistance[e.to] = newDistance;
					}else{
						shortestDistance[e.to] = Math.min(shortestDistance[e.to], newDistance);
					}
				}
			}
		}
		return shortestDistance;
	}

	private int[] topologicalSort(HashMap<Integer, List<Edge>> graph, int n) {
		int[] ordering = new int[n];
		boolean[] visited = new boolean[n];
		int i = n - 1;
		for(int at=0; at < n; at++){
			if(!visited[at]){
				i = dfs(i, at, graph, ordering, visited);
			}
		}
		return ordering;
	}

	private int dfs(int i, int at, HashMap<Integer, List<Edge>> graph, int[] ordering, boolean[] visited) {
		visited[at] = true;
		
		for(Edge e : graph.get(at)){
			if(!visited[e.to]){
				i = dfs(i, e.to, graph, ordering, visited);
			}
		}
		ordering[i] = at;
		return i-1;
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