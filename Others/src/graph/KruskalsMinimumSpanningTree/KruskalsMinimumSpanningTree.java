package graph.KruskalsMinimumSpanningTree;

import java.util.Arrays;

public class KruskalsMinimumSpanningTree {
	
	public static void main(String[] args) {
			
	}

	/* Approach : Using Union Find Algorithm
	 * Time Complexity : O(E* log(E)), where E is number of Edges
	 * Space Complexity : O(V), where V is number of Vertices
	 */
	 static Long kruskals(Edge[] edges, int n) {

	    if (edges == null){
	    	return null;
	    }

	    long sum = 0L;
	    Arrays.sort(edges);
	    UnionFind uf = new UnionFind(n);

	    for(Edge edge : edges) {
	      // Skip this edge to avoid creating a cycle in MST
	      if (uf.isConnected(edge.from, edge.to)){
	    	  continue;
	      }
	      // Include this edge
	      uf.union(edge.from, edge.to);
	      sum += edge.cost;
	      // Optimization to stop early if we found
	      // a MST that includes all the nodes
	      if (uf.size(0) == n){
	    	  break;
	      }
	    }

	    // Make sure we have a MST that includes all the nodes
	    if (uf.size(0) != n){
	    	return null;
	    }

	    return sum;
	  }
	 
	static class UnionFind{
		int ids[];
		int size[];
		
		public UnionFind(int n){
			ids = new int[n];
			size = new int[n];
			for(int i=0; i < n; i++){
				ids[i] = i;
				size[i] = 1;
			}
		}
		
		/* Approach : Path Compression
		 * Time Complexity : O(log(V)), where E is number of Edges
		 * Space Complexity : O(V), where V is number of Vertices
		 */
		public int find(int p){
			int root = p;
			while(root != ids[p]){
				root = ids[p];
			}
			while(p != root){ //Path compression
				int next = ids[p];
				ids[p] = root;
				p = next;
			}
			return root;
		}
		
		/* Approach : Rank
		 * Time Complexity : O(log(V)), where E is number of Edges
		 * Space Complexity : O(V), where V is number of Vertices
		 */
		public void union(int p, int q){
			int root1 = find(p);
			int root2 = find(q);
			
			if(root1 == root2){
				return;
			}
			if(size[root1] > size[root2]){
				ids[root2] = root1;
				size[root1] += size[root2];
			}else{
				ids[root1] = root2;
				size[root2] += size[root2];
			}
		}
		
		public boolean isConnected(int p, int q){
			return find(p) == find(q);
		}
		
		public int size(int p){
			return size[find(p)];
		}
	}
	
	static class Edge implements Comparable<Edge> {
	    int from, to, cost;

	    public Edge(int from, int to, int cost) {
	      this.from = from;
	      this.to = to;
	      this.cost = cost;
	    }

	    @Override
	    public int compareTo(Edge other) {
	      return cost - other.cost;
	    }
	  }

}

