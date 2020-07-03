package tree.InorderSuccessorInBST;

import tree.TreeNode;

public class InorderSuccessorInBST {
	
	/*Approach 1 : 
	 * Time Complexity: O(Log(n)) - or h, where h is height of tree
	 * Space Complexity: O(Log(n)) , where is n is number of nodes
	*/
	
public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        TreeNode givenElement = find(root, p);
        if(givenElement == null){
            return null;
        }else if(givenElement.right != null){
            return smallestElement(givenElement.right);
        }else{
            TreeNode ans = null;
            while(root.val != p.val){
                if(root.val > p.val) ans = root;
                if(p.val < root.val){
                    root = root.left;
                }else{
                    root = root.right;
                }
            }
            return ans;
        }
    }
    public TreeNode smallestElement(TreeNode root){
        if(root.left == null){
            return root;
        }else{
            return smallestElement(root.left);
        }
    }
    public TreeNode find(TreeNode root, TreeNode p){
        TreeNode curr = root;
        while(curr != null){
            if(curr.val == p.val){
                break;
            }else if(p.val < curr.val){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
        return curr;
    }
}