package graph.FindingArticulationPointsInGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindingArticulationPointsInGraph {
	
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

	    FindingArticulationPointsInGraph obj = new FindingArticulationPointsInGraph();
	    boolean[] articulationPoints = obj.findArticulationPoints(graph, n);
	    
	    for(int i=0; i < n; i++){
	    	if(articulationPoints[i]){
	    		System.out.print(i + "   ");
	    	}
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
	boolean[] articulationPoints;
	int countOfOutgoingEdges; 
	private boolean[] findArticulationPoints(List<List<Integer>> graph, int n) {
		ids = new int[n];
		lowLinks = new int[n];
		visited = new boolean[n];
		articulationPoints = new boolean[n];
		for(int i = 0; i < n; i++){
			if(!visited[i]){
				countOfOutgoingEdges = 0;
				dfs(i, i, -1, graph);
				articulationPoints[i] = countOfOutgoingEdges > 1;
			}
		}
		return articulationPoints;
	}
	
	private void dfs(int root, int at, int parent, List<List<Integer>> graph) {
		id++;
		ids[at] = id;
		lowLinks[at] = id;
		visited[at] = true;
		if(parent == root){
			countOfOutgoingEdges++;
		}
		for(int to : graph.get(at)){
			if(to == parent){
				continue;
			}
			if(!visited[to]){
				dfs(root, id, at, graph);
				lowLinks[at] = Math.min(lowLinks[at], lowLinks[to]);
				if(ids[at] <= lowLinks[to]){
					articulationPoints[at] = true;
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

