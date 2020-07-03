 package dynamicProgramming.UniqueBST_2;

import java.util.ArrayList;
import java.util.List;

public class UniqueBST_2 {
	public static void main(String[] args) {
		UniqueBST_2 obj = new UniqueBST_2();
		obj.generateTrees(3);
	}
	/*Approach 1 : 
	 * Time Complexity: 
	 * Space Complexity: 
	*/
	public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<TreeNode>();
        }
        return genTrees(1,n);
    }
    public List<TreeNode> genTrees (int start, int end){
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(start>end){
            list.add(null);
            return list;
        }        
        List<TreeNode> left,right;
        for(int i=start;i<=end;i++){
            left = genTrees(start, i-1);
            right = genTrees(i+1,end);
            for(TreeNode lnode: left){
                for(TreeNode rnode: right){
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }     
        }
        return list;
    }
}
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
