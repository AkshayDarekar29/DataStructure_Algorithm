 package tree.DeleteNodeInBST;

import tree.TreeNode;

public class DeleteNodeInBST {
	
	/* Approach - 
	 * Time Complexity - O(log(n))
	 * Space Complexity - O(1)
	 */
	public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }else if(key < root.val){
           root.left = deleteNode(root.left, key);
        }else if(key > root.val){
           root.right = deleteNode(root.right, key); 
        }else{
            if(root.left != null && root.right != null){
                TreeNode minElementAtRight = getMinimumElement(root.right);
                root.val = minElementAtRight.val;
                root.right = deleteNode(root.right, minElementAtRight.val);
            }else if(root.left != null){
                root = root.left;
            }else if(root.right != null){
                root = root.right;
            }else{
                return null;
            }
        }
       return root;
   }
   
   public TreeNode getMinimumElement(TreeNode root){
       if(root.left == null){
           return root;
       }else{
           return getMinimumElement(root.left);
       }
   }
}
