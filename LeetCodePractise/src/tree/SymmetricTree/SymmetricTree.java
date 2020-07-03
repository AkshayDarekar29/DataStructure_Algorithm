package tree.SymmetricTree;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;

public class SymmetricTree {
	
	/*Approach 1 : Iteration
	 * Time Complexity: O(n)
	 * Space Complexity: O(n) , where is n is number of nodes
	*/
	public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root.left);
        q2.offer(root.right);
        
        while(!q1.isEmpty() || !q2.isEmpty( )){
            int len = q1.size();
            for(int i=0; i< len; i++){
                TreeNode left = q1.poll();
                TreeNode right = q2.poll();
                if(left != null || right != null){
                    if(left == null || right == null || left.val != right.val){
                       return false;
                    }else{
                        q1.offer(left.left);
                        q1.offer(left.right);
                        q2.offer(right.right);
                        q2.offer(right.left);
                    }
                }
            }
        }
        return true;
    }
	
	/*Approach 2 : Iteration 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n) , where is n is number of nodes
	*/
	public boolean isSymmetric_2(TreeNode root) {
	    Queue<TreeNode> q = new LinkedList<>();
	    q.add(root);
	    q.add(root);
	    while (!q.isEmpty()) {
	        TreeNode t1 = q.poll();
	        TreeNode t2 = q.poll();
	        if (t1 == null && t2 == null) continue;
	        if (t1 == null || t2 == null) return false;
	        if (t1.val != t2.val) return false;
	        q.add(t1.left);
	        q.add(t2.right);
	        q.add(t1.right);
	        q.add(t2.left);
	    }
	    return true;
	}
	
	/*Approach 3 : Recursion
	 * Time Complexity: O(n)
	 * Space Complexity: O(n) , where is n is number of nodes
	*/
	public boolean isSymmetric_3(TreeNode root) {
        return root == null? true : isSymmetric2(root.left, root.right);
    }
    
    public boolean isSymmetric2(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null || left.val != right.val){
            return false;
        }else{
            return isSymmetric2(left.left, right.right) && isSymmetric2(left.right, right.left);
        }
    }
}
