 package tree.InsertInBST;

import tree.TreeNode;

public class InsertInBST {
	
	/* Approach - Go to left or right side by comparing root and given element and insert the element
	 * Time Complexity - O(log(n))
	 * Space Complexity - O(1)
	 */
	public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode curr = root;
        if(curr == null){
            return new TreeNode(val);
        }
        while(curr != null){
            if(val < curr.val){
                if(curr.left == null){
                    curr.left = new TreeNode(val);
                    break;
                }else {
                    curr = curr.left;
                }
            }else{
                if(curr.right == null){
                    curr.right = new TreeNode(val);
                    break;
                }else {
                    curr = curr.right;
                }
            }
        }
        return root;
    }
}
