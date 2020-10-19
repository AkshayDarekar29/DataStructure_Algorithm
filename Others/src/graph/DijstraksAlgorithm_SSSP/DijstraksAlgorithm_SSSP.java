package graph.DijstraksAlgorithm_SSSP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class DijstraksAlgorithm_SSSP {
	
	public static void main(String[] args) {
		HashMap<Integer, List<Edge>> graph = new HashMap<>();
		int n = 7;
		for (int i = 0; i < n; i++) {
			graph.put(i, new ArrayList<>());
		}
		
		graph.get(0).add(new Edge(0, 1, 3));
	    graph.get(0).add(new Edge(0, 2, 8));
	    graph.get(0).add(new Edge(0, 5, 3));
	    graph.get(1).add(new Edge(1, 3, 1));
	    graph.get(1).add(new Edge(1, 2, 2));
	    graph.get(2).add(new Edge(2, 3, 1));
	    graph.get(2).add(new Edge(2, 4, 10));
	    graph.get(3).add(new Edge(3, 4, 5));
	    graph.get(5).add(new Edge(5, 4, 1));
	    
	    DijstraksAlgorithm_SSSP obj = new DijstraksAlgorithm_SSSP();
	    int [] shortestDistance = obj.shortestPathByDijstrak(graph, 0, n);
	    System.out.println(Arrays.toString(shortestDistance));
	    ArrayList<Integer> path = obj.reconstructPath(0, 4, shortestDistance);
	    for(int i : path){
	    	System.out.print(i + "->");
	    }
	}

	/* Approach 1 : Dijstrak's Algorithm
	 * Time Complexity : O((E+ V)*Log(V)), where E is number of Edges
	 * Space Complexity : O(V), where V is number of Vertices
	 */
	
	Comparator<Node> comparator = (i, j) -> {
		if(i.value > j.value){
			return 1;
		}else if(i.value < j.value){
			return -1;
		}else{
			return 0;
		}
	};
	
	Integer[] prev;
	private int[] shortestPathByDijstrak(HashMap<Integer, List<Edge>> graph, int start, int n) {
		int[] shortestDistance = new int[n];
		Arrays.fill(shortestDistance, Integer.MAX_VALUE);
		shortestDistance[start] = 0;
		PriorityQueue<Node> queue = new PriorityQueue<>(comparator);
		queue.offer(new Node(start, 0));
		boolean[] visited = new boolean[n];
		prev = new Integer[n];
		while(!queue.isEmpty()){
			Node node = queue.poll();
			visited[node.id] = true;
			
			if(shortestDistance[node.id] < node.value){
				continue;
			}
			
			for(Edge e : graph.get(node.id)){
				if(visited[e.to]){
					continue;
				}
				int newDistance = shortestDistance[node.id] + e.weight;
				if(newDistance < shortestDistance[e.to]){
					shortestDistance[e.to] = newDistance;
					queue.offer(new Node(e.to, newDistance));
					prev[e.to] = node.id;
				}
			}
		}
		return shortestDistance;
	}
	
	public ArrayList<Integer> reconstructPath(int start, int end, int[] shortestDistance){
		ArrayList<Integer> path = new ArrayList<>();
		if(shortestDistance[end] != Integer.MAX_VALUE){
			for(Integer at = end; at != null; at=prev[at]){
				path.add(at);
			}
		}
		Collections.reverse(path);
		return path;
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