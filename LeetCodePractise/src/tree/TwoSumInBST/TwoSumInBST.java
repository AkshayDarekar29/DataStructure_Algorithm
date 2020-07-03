 package tree.TwoSumInBST;

import java.util.HashSet;

import tree.TreeNode;

public class TwoSumInBST {
	/* Approach - Hashset
	 * Time Complexity - O(n)
	 * Space Complexity - O(n)
	 */
	HashSet<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        return traverseAndComplement(root, k);
    }
    
    public boolean traverseAndComplement(TreeNode root, int k){
        if(root == null){
            return false;
        }
        if(set.contains(root.val)){
            return true;
        }
        if(k - root.val != root.val) set.add(k-root.val);
        if(traverseAndComplement(root.left, k)){
            return true;
        }
        if(traverseAndComplement(root.right, k)){
            return true;
        }
        return false;
    }
}