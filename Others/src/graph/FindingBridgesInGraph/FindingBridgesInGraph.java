package graph.FindingBridgesInGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindingBridgesInGraph {
	
	public static void main(String[] args) {
		
		int n = 9;
	    List<List<Integer>> graph = createGraph(n);

	    addEdge(graph, 0, 1);
	    addEdge(graph, 0, 2);
	    addEdge(graph, 1, 2);
	    addEdge(graph, 2, 3);
	    addEdge(graph, 3, 4);
	    addEdge(graph, 2, 5);
	    addEdge(graph, 5, 6);
	    addEdge(graph, 6, 7);
	    addEdge(graph, 7, 8);
	    addEdge(graph, 8, 5);

	    FindingBridgesInGraph obj = new FindingBridgesInGraph();
	    ArrayList<Integer> bridges = obj.findBridges(graph, n);
	    
	    for (int i = 0; i < bridges.size() / 2; i++) {
	        int node1 = bridges.get(2 * i);
	        int node2 = bridges.get(2 * i + 1);
	        System.out.printf("Bridge between nodes: %d and %d\n", node1, node2);
	    }
	    
	}

	/* Approach 1 :
	 * Time Complexity : O(E + V), where E is number of Edges
	 * Space Complexity : O(V), where V is number of Vertices
	 */
	int[] ids;
	int[] lowLinks;
	int id = 0;
	boolean[] visited;
	ArrayList<Integer> bridges;
	private ArrayList<Integer> findBridges(List<List<Integer>> graph, int n) {
		ids = new int[n];
		lowLinks = new int[n];
		visited = new boolean[n];
		bridges = new ArrayList<>();
		for(int i = 0; i < n; i++){
			if(!visited[i]){
				dfs(i, -1, graph);
			}
		}
		return bridges;
	}
	
	private void dfs(int at, int parent, List<List<Integer>> graph) {
		id++;
		ids[at] = id;
		lowLinks[at] = id;
		visited[at] = true;
		for(int to : graph.get(at)){
			if(to == parent){
				continue;
			}
			if(!visited[to]){
				dfs(id, at, graph);
				lowLinks[at] = Math.min(lowLinks[at], lowLinks[to]);
				if(ids[at] < lowLinks[to]){
					bridges.add(at);
					bridges.add(to);
				}
			}else{
				lowLinks[at] = Math.min(lowLinks[at], ids[to]);
			}
		}
	}
	
	 public static List<List<Integer>> createGraph(int n) {
	    List<List<Integer>> graph = new ArrayList<>();
	    for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
	    return graph;
	  }
	 
	 public static void addEdge(List<List<Integer>> graph, int from, int to) {
	    graph.get(from).add(to);
	    graph.get(to).add(from);
	  }

}

