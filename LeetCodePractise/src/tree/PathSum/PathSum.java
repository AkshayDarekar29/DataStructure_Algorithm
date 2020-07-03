package tree.PathSum;

import tree.TreeNode;

public class PathSum {
	
	/*Approach 1 : DFS
	 * Space Complexity: O(n) , where is n is number of nodes
	*/
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        return dfs(root, sum - root.val);
    }
    
    public boolean dfs(TreeNode root, int sum){
        if(root.left == null && root.right == null && sum == 0){
            return true;
        }else{
           if(root.left != null && dfs(root.left, sum - root.left.val)){
               return true;
           }else if(root.right != null && dfs(root.right, sum - root.right.val)){
               return true; 
           }
        }
        return false;
    }
}
