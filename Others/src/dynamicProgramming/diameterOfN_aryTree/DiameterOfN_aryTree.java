package dynamicProgramming.diameterOfN_aryTree;

import java.util.ArrayList;
import java.util.List;

public class DiameterOfN_aryTree {
	public static void main(String[] args) {
		Node root = new Node(1); 
	    //(root.child).add(new Node(2)); 
	    (root.child).add(new Node(3)); 
	    (root.child).add(new Node(4)); 
	    (root.child).add(new Node(5)); 
	    (root.child.get(0).child).add(new Node(6)); 
	    (root.child.get(0).child).add(new Node(7)); 
	    //(root.child.get(2).child).add(new Node(8)); 
	    //(root.child.get(3).child).add(new Node(9)); 
	    //(root.child.get(3).child).add(new Node(10)); 
	    //(root.child.get(3).child).add(new Node(11)); 
	    (root.child.get(0).child.get(0).child).add(new Node(12)); 
	    (root.child.get(0).child.get(0).child).add(new Node(13)); 
	    //(root.child.get(3).child.get(2).child).add(new Node(14));
	    
	    (root.child.get(0).child.get(0).child.get(0).child).add(new Node(19)); 
	    
	    (root.child.get(0).child.get(1).child).add(new Node(15)); 
	    (root.child.get(0).child.get(1).child.get(0).child).add(new Node(16)); 
	    (root.child.get(0).child.get(1).child.get(0).child.get(0).child).add(new Node(17));
	    (root.child.get(0).child.get(1).child.get(0).child.get(0).child.get(0).child).add(new Node(17)); 
	    DiameterOfN_aryTree obj = new DiameterOfN_aryTree();
	    System.out.print(obj.diameter(root)); 
	}
	 
	/*Approach 1 : DFS
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	*/
	int maxDia = 0;
	public int diameter(Node root){
		dfs(root);
		return maxDia;
	}
	public int dfs(Node root){
		int max1 = 0;
		int max2 = 0;
		if(root == null){
			return 0;
		}
		
		for(Node child : root.child){
			int h = dfs(child);
			if(h >= max1){
				max2 = max1;
				max1 = h;
			}else if(h > max2){
				max2 = h;
			}
		}
		maxDia = Math.max(maxDia, max1 + max2);
		return 1 + max1;
	}
}

class Node{
	int value;
	List<Node> child;
	
	public Node(int value){
		this.value = value;
		this.child = new ArrayList<>();
	}
}