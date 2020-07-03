package tree.VerticalOrderTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import tree.TreeNode;

public class VerticalOrderTraversal {
	
	/*Approach 1 : dfs and OOPS
	 * Time Complexity: O(nLog(n)) - collections.sort() takes nLog(n) time to sort
	 * Space Complexity: O(n) , where is n is number of nodes
	*/
	List<Location> locations;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        locations = new ArrayList<>();
        dfs(root, 0, 0);
        Collections.sort(locations);
        
        List<List<Integer>> list = new ArrayList<>();
        int i = 0;
        int currX = locations.get(0).x;
        List<Integer> l = new ArrayList<>();
        while(i < locations.size()){
            if(locations.get(i).x != currX){
                currX = locations.get(i).x;
                list.add(l);
                l = new ArrayList<>();
            }
            l.add(locations.get(i).val);
            i++;
        }
        list.add(l);
        return list;
    }
    
    public void dfs(TreeNode node, int x, int y){
        if(node == null){
            return;
        }else{
            locations.add(new Location(x, y, node.val));
            dfs(node.left, x-1, y+1);
            dfs(node.right, x+1, y+1);
        }
    }
}

class Location implements Comparable<Location>{
    int x, y, val;
    Location(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public int compareTo(Location that){
        if(this.x != that.x){
            return Integer.compare(this.x, that.x);
        }else if(this.y != that.y){
            return Integer.compare(this.y, that.y);
        }else{
            return Integer.compare(this.val, that.val);
        }
    }
}