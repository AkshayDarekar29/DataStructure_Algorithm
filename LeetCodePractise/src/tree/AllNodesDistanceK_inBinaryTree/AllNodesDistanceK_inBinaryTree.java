 package tree.AllNodesDistanceK_inBinaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import tree.TreeNode;

public class AllNodesDistanceK_inBinaryTree {
	public static void main(String[] args) {
		TreeNode four = new TreeNode(4);
		TreeNode seven = new TreeNode(7);
		TreeNode two = new TreeNode(2);
		two.left = seven;
		two.right = four;
		TreeNode six = new TreeNode(6);
		TreeNode five = new TreeNode(5);
		five.left = six;
		five .right = two;
		TreeNode zero = new TreeNode(0);
		TreeNode eight = new TreeNode(8);
		TreeNode one = new TreeNode(1);
		one.left = zero;
		one.right = eight;
		TreeNode three = new TreeNode(3);
		three.left = five;
		three.right = one;
		AllNodesDistanceK_inBinaryTree obj = new AllNodesDistanceK_inBinaryTree();
		List<Integer> list = obj.distanceK(three, five, 2);
		for(int n : list){
			System.out.print( n + " ");
		}
	}
	/* Approach - 
	 * Time Complexity - 
	 * Space Complexity - 
	 */
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        Node rootNode = new Node(root);
        Queue<Node> q = new LinkedList<>();
        Node tarNode = null;
        q.offer(rootNode);
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.val == target.val){
                tarNode = temp;
            }
            if(temp.left != null){
                Node left = temp.left;
                left.parent = temp;
                q.offer(left);
            }
            if(temp.right != null){
                Node right = temp.right;
                right.parent = temp;
                q.offer(right);
            }
        }
        q.offer(tarNode);
        int level = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(tarNode.val);
        while(K != 0 && !q.isEmpty()){
        	int len = q.size();
        	for(int i=0; i < len; i++){
        		Node temp = q.poll();
                if(temp.left != null && !visited.contains(temp.left.val)){
                    visited.add(temp.left.val);
                    q.offer(temp.left);
                }
                if(temp.right != null && !visited.contains(temp.right.val)){
                    visited.add(temp.right.val);
                    q.offer(temp.right);
                }
                if(temp.parent != null && !visited.contains(temp.parent.val)){
                    visited.add(temp.parent.val);
                    q.offer(temp.parent);
                }
        	}
        	level++;
        	if(level == K){
        		break;
        	}
        }
        while(!q.isEmpty()){
            result.add(q.poll().val);
        }
        return result;
    }
}
             

class Node {
    int val;
    Node left;
    Node right;
    Node parent;
    Node(TreeNode x) { 
        this.val = x.val;
        if(x.left != null) this.left = new Node(x.left);
        if(x.right != null) this.right = new Node(x.right);
    }
}
