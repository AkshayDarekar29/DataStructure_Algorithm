package tree.DiameterOfBinaryTree;

import tree.TreeNode;

public class DiameterOfBinaryTree {
	
	/*Approach 1 : Recursion
	 * Time Complexity: O(n)
	 * Space Complexity: O(n) , where is n is number of nodes
	*/
	int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return dia;
    }
    
    public int depth(TreeNode root) {
        if (root == null)
            return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        dia = Math.max(dia, l+r);
        return Math.max(l,r) + 1;
    }
}
