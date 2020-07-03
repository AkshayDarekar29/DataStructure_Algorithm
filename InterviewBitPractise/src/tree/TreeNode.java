package tree;

public class TreeNode {
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
    
    public static TreeNode getTree(){
  	  TreeNode root = new TreeNode(5);
  	  TreeNode rootLeft = new TreeNode(10);
  	  TreeNode rootright= new TreeNode(20);
  	  root.left = rootLeft;
  	  root.right = rootright;
  	  TreeNode rootLeft_l = new TreeNode(4);
  	  TreeNode rootLeft_R = new TreeNode(3);
  	  rootLeft.left = rootLeft_l;
  	  rootLeft.right = rootLeft_R;
  	  TreeNode rootright_r= new TreeNode(25);
  	  rootright.right = rootright_r;
  	  return root;

  	  
    }
}