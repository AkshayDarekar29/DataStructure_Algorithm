package tree.TopView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import tree.TreeNode;

public class TopView2 {
	
	/*Approach 1 : dfs and OOPS
	 * Time Complexity: O(n)
	 * Space Complexity: O(n) , where is n is number of nodes
	*/
	
	List<Location> locations;
    public List<Integer> verticalTraversal(TreeNode root) {
        locations = new ArrayList<>();
        dfs(root, 0, 0);
        HashMap<Integer, Integer> hash = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int z =0; z < maxX-minX+1; z++){
            list.add(0);
        }
        for(Location location : locations){
            if(hash.containsKey(location.x)){
               int oldY = hash.get(location.x);
                if(oldY > location.y){
                    hash.put(location.x, location.y);
                }
            }else{
                hash.put(location.x, location.y);
            }
        }
        for(Location location : locations){
            if(hash.containsKey(location.x) && hash.get(location.x) == location.y){
                list.set(Math.abs(minX)+location.x, location.val);
            }
        }
        return list;
    }
    int minX;
    int maxX;
    public void dfs(TreeNode node, int x, int y){
        if(node == null){
            return;
        }
        if(minX > x){
            minX = x;
        }
        if(maxX < x){
            maxX = x;
        }
        locations.add(new Location(x, y, node.val));
        dfs(node.left, x-1, y+1);
        dfs(node.right, x+1, y+1);
    }
    class Location{
        int x, y, val;
        Location(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}