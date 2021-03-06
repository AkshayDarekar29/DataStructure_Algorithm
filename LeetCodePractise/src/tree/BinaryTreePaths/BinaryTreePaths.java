package tree.BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.TreeNode;

public class BinaryTreePaths {
	
	/*Approach 1 : DFS and Backtracking
	 * Time Complexity: O(n)
	 * Space Complexity: O(n) , where is n is number of nodes
	*/
	List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new ArrayList<>());
        return list;
    }
    
    public void dfs(TreeNode root, List<Integer> l){
        if(root == null){
            return;
        }
        else if(root.left == null && root.right == null){
            l.add(root.val);
            StringBuilder s = new StringBuilder();
            for(int i = 0; i < l.size(); i++){
                if(i != 0){
                    s.append("->");
                }
                s.append(Integer.toString(l.get(i)));
            }
            list.add(s.toString());
            l.remove(l.size()-1);
        }else{
            l.add(root.val);
            dfs(root.left, l);
            dfs(root.right, l);
            l.remove(l.size()-1);
        }
    }
}
