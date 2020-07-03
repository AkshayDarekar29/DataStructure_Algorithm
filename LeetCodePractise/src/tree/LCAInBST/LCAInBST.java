 package tree.LCAInBST;

import tree.TreeNode;

public class LCAInBST {
	
	/* Approach - 
	 * Time Complexity - O(log(n))
	 * Space Complexity - O(1)
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        TreeNode curr = root;
        TreeNode lca = null;
        if(p.val>q.val){
            TreeNode temp = q;
            q= p;
            p = temp;
        }
        while(curr != null){
            if(p.val <= curr.val && curr.val <= q.val){
                lca = curr;
                break;
            }else if(p.val <= curr.val && curr.val >= q.val){
                curr = curr.left;
            }else if(p.val >= curr.val && curr.val <= q.val){
                curr = curr.right;
            }
        }
        return lca;
    }
}
