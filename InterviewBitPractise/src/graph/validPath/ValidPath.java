package graph.validPath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ValidPath {
	 public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
	        int n = C;
	        int r = D;
	        int [][] valid = new int[A+1][B+1];
	        for(int i=0; i <=A; i++){
	            for(int j=0; j <=B; j++){
	                for(int z=0; z < n; z++){
	                    if(Math.sqrt(Math.pow(E.get(z)-i, 2) + Math.pow(F.get(z)-j, 2)) <= r){
	                        valid[i][j] = -1;
	                    }
	                }
	            }
	        }
	        if(valid[0][0] == -1 || valid[A][B] == -1){
	            return "NO";
	        }
	        int[] x = {1,1,1,-1,-1,-1,0,0};
	        int[] y = {-1,1,0,-1,1,0,1,-1};
	        boolean[][] visited = new boolean[A+1][B+1];
	        Queue<Integer> q = new LinkedList<>();
	        q.offer(0);
	        q.offer(0);
	        visited[0][0] = true;
	        while(!q.isEmpty()){
	            int i = q.poll();
	            int j = q.poll();
	            for(int z=0; z < 8; z++){
	                int tx = i + x[z];
	                int ty = j + y[z];
	                if(!(tx < 0 || tx > A || ty < 0 || ty > B ) && valid[tx][ty] != -1 && !visited[tx][ty]){
	                    if(tx == A && ty == B){
	                        return "YES";
	                    }
	                    q.offer(tx);
	                    q.offer(ty);
	                    visited[tx][ty] = true;
	                }
	            }
	        }
	        return "NO";
	    }
}