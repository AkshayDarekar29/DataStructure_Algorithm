 package tree.SearchInBST;

import tree.TreeNode;

public class SearchInBST {
	
	/* Approach - Go to left or right side by comparing root and given element
	 * Time Complexity - O(log(n))
	 * Space Complexity - O(1)
	 */
	public TreeNode searchBST(TreeNode root, int val) {
        TreeNode curr = root;
        while(curr != null){
            if(curr.val == val){
                break;
            }else if(val < curr.val){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
        return curr;
    }
}
