package tree.LevelOrderTraversal;


import java.util.ArrayList; 
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.TreeNode;

public class LevelOrderTraversal {
	
	/*Approach 1 : Iteration and Queue
	 * Time Complexity: O(n)
	 * Space Complexity: O(x) , where is n is number of nodes and x is number of nodes in last level
	*/
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();  
		if (root == null) return res;  
		Queue<TreeNode> queue = new LinkedList<>();  
		queue.add(root);  
		while (!queue.isEmpty()) {  
			List<Integer> level = new ArrayList<>();  
			int cnt = queue.size();  
			for (int i = 0; i < cnt; i++) {  
				TreeNode node = queue.poll();  
				level.add(node.val);  
			    if (node.left != null) {  
			    	queue.add(node.left);  
			    }
				if (node.right != null) {  
					queue.add(node.right);  
				}
			}  
			res.add(level);   
		}  
		return res;
    }

	
	/*Approach 1 : Iteration and two Queues
	 * Time Complexity: O(n)
	 * Space Complexity: O(n) , where is n is number of nodes and x is number of nodes in last level
	*/
	
	public List<List<Integer>> levelOrder_2(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        List<Integer> li = new ArrayList<>();
        li.add(root.val);
        list.add(li);
        q1.add(root);
        while(!q1.isEmpty()){
            while(!q1.isEmpty()){
                TreeNode x = q1.remove();
                if(x.left != null){
                    q2.add(x.left);
                }
                if(x.right != null){
                    q2.add(x.right);
                } 
            }
            List<Integer> l = new ArrayList<>();
            while(!q2.isEmpty()){
                TreeNode temp = q2.remove();
                q1.add(temp);
                l.add(temp.val);
            }
            if(!l.isEmpty()){
                list.add(l);
            }
        }
        return list;
    }

}
