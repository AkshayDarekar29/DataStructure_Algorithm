package tree.RightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import tree.TreeNode;

public class RightSideView {
	
	/*Approach 1 : BFS
	 * Time Complexity: O(n)
	 * Space Complexity: O(n) , where is n is number of nodes
	*/
	public List<Integer> rightSideView_bfs(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                TreeNode node = q.poll();
                if(i == len-1){
                    list.add(node.val);
                }
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);   
            }
        }
        return list;
    }
	
	/*Approach 2 : DFS
	 * Time Complexity: O(n)
	 * Space Complexity: O(n) , where is n is number of nodes
	*/
	List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView_dfs(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightView(root, 0, list);
        return list;
    }
    
    public void rightView(TreeNode root, int depth, List<Integer> list){
        if(root == null){
            return;
        }
        if(depth == list.size()){
            list.add(root.val);
        }
        rightView(root.right, depth+1, list);
        rightView(root.left, depth+1, list);
    }
}
