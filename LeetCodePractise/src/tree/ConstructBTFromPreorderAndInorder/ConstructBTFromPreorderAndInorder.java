package tree.ConstructBTFromPreorderAndInorder;

import tree.TreeNode;

public class ConstructBTFromPreorderAndInorder {
	
	/*Approach 1 : Divide inorder array into left and right subtree based on given preorder array
	 * Time Complexity: O(n)
	 * Space Complexity: O(n) , where is n is number of nodes
	*/
	int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length-1); 
    }
    
    public TreeNode build( int[] preorder, int[] inorder, int l, int h){
        if(preIndex > inorder.length || l > h){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preIndex]);
        preIndex++;
        if(l == h || preIndex == inorder.length){
            return node;
        }
        int i;
        for(i = l; i <= h; i++){
            if(node.val == inorder[i]){
                break;
            }
        }
        node.left = build(preorder, inorder, l, i-1);
        node.right = build(preorder, inorder, i+1, h);
        
        return node;
    }
}
