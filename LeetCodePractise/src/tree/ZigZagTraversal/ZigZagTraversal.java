package tree.ZigZagTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import tree.TreeNode;

public class ZigZagTraversal {
	
	/*Approach 1 : Iteration - using queue only
	 * Time Complexity: O(n)
	 * Space Complexity: O(n) , where is n is number of nodes
	*/
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        q.offer(root);
        boolean reverse = false;
        while(!q.isEmpty()){
            LinkedList<Integer> level = new LinkedList<>();
            int len = q.size();
            for(int i=0; i<len; i++){
                TreeNode node = q.poll();
                if(reverse){
                    level.addFirst(node.val);
                }else{
                    level.add(node.val);
                }
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            reverse = !reverse;
            list.add(level);
        }
        return list;
    }
	
	/*Approach 2 : Iteration - using queue and stack
	 * Time Complexity: O(n)
	 * Space Complexity: O(n) , where is n is number of nodes
	*/
	public List<List<Integer>> zigzagLevelOrder_2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        q.offer(root);
        Stack<TreeNode> stack = new Stack<>();
        boolean toggle = true;
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            while(!q.isEmpty()){
                TreeNode temp = q.poll();
                level.add(temp.val);
                stack.push(temp);
            }
            list.add(level);
            int len = stack.size();
            for(int i=0; i<len; i++){
                TreeNode node = stack.pop();
                if(!toggle){
                    if(node.left != null){
                        q.offer(node.left);
                    }
                    if(node.right != null){
                        q.offer(node.right);
                    }
                }else{
                    if(node.right != null){
                        q.offer(node.right);
                    }
                    if(node.left != null){
                        q.offer(node.left);
                    }
                }
            }
            toggle = !toggle;
        }
        return list;
    }
}
