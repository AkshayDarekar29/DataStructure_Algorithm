package graph.TarjansSCC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TarjansSCC {
	
	public static void main(String[] args) {
		
		int n = 8;
	    List<List<Integer>> graph = createGraph(n);

	    addEdge(graph, 6, 0);
	    addEdge(graph, 6, 2);
	    addEdge(graph, 3, 4);
	    addEdge(graph, 6, 4);
	    addEdge(graph, 2, 0);
	    addEdge(graph, 0, 1);
	    addEdge(graph, 4, 5);
	    addEdge(graph, 5, 6);
	    addEdge(graph, 3, 7);
	    addEdge(graph, 7, 5);
	    addEdge(graph, 1, 2);
	    addEdge(graph, 7, 3);
	    addEdge(graph, 5, 0);

	    TarjansSCC obj = new TarjansSCC();
	    int[] lowLinks = obj.getSCC(graph, n);
	    System.out.println(obj.numberOfSSC);
	    System.out.println(Arrays.toString(lowLinks));
	    Map<Integer, List<Integer>> multimap = new HashMap<>();
	    for (int i = 0; i < n; i++) {
	      if (!multimap.containsKey(lowLinks[i])){
	    	  multimap.put(lowLinks[i], new ArrayList<>());
	      }
	      multimap.get(lowLinks[i]).add(i);
	    }

	    for (List<Integer> scc : multimap.values()) {
	      System.out.println("Nodes: " + scc + " form a Strongly Connected Component.");
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
	boolean[] inStack;
	int numberOfSSC = 0;
	Stack<Integer> stack; 
	
	private int[] getSCC(List<List<Integer>> graph, int n) {
		ids = new int[n];
		lowLinks = new int[n];
		visited = new boolean[n];
		inStack = new boolean[n];
		stack = new Stack<>();
		for(int i=0; i<n; i++){
			if(!visited[i]){
				dfs(i, graph);
			}
		}
		return lowLinks;
	}
	
	private void dfs(int at, List<List<Integer>> graph) {
		id++;
		ids[at] = id;
		lowLinks[at] = id;
		visited[at] = true;
		stack.push(at);
		inStack[at] = true;
		for(int to : graph.get(at)){
			if(!visited[to]){
				dfs(to, graph);
			}
			if(inStack[to]){
				lowLinks[at] = Math.min(lowLinks[at], lowLinks[to]);
			}
		}
				
		if(ids[at] == lowLinks[at]){
			while(!stack.isEmpty()){
				int node = stack.pop();
				inStack[node] = false;
				//lowLinks[node] = ids[at];
				if(node == at){
					break;
				}
			}
			numberOfSSC++;
		}
	}
	
	 public static List<List<Integer>> createGraph(int n) {
	    List<List<Integer>> graph = new ArrayList<>();
	    for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
	    return graph;
	  }
	 
	 public static void addEdge(List<List<Integer>> graph, int from, int to) {
	    graph.get(from).add(to);
	  }

}

