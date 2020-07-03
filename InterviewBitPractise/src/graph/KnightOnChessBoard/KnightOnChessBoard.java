package graph.KnightOnChessBoard;

import java.util.LinkedList;
import java.util.Queue;

public class KnightOnChessBoard {
	/* Approach : BFS
	 * Time Complexity : O(A*B)
	 * Space Complexity : O(A*B)
	 */
	public int knight(int A, int B, int C, int D, int E, int F) {
        if(C == E && D == F){
            return 0;
        }
        Queue<int []> q = new LinkedList<>();
        boolean [][] visited = new boolean[A+1][B+1];
        int [] xy = {C, D};
        q.offer(xy);
        visited[C][D] = true;
        int [] xList = {2,1,-1,-2,-2,-1,1,2};
        int [] yList = {1,2,2,1,-1,-2,-2,-1};
        int count = 0;
        while(!q.isEmpty()){
            count++;
            int len = q.size();
            for(int n=0; n < len; n++){
                int [] temp = q.poll();
                C = temp[0];
                D = temp[1];
                for(int i=0; i<8; i++){
                    int newX = C + xList[i];
                    int newY = D + yList[i];
                    if(newX == E && newY == F){
                        return count;
                    }else if(isSafe(newX, newY, A, B, visited)){
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
        }
        return -1;
    }
    
    private boolean isSafe(int nextX, int nextY, int A, int B, boolean[][] visited) {
		if(nextX >= 1 && nextX <= A && nextY >= 1 && nextY <= B && !visited[nextX][nextY]){
		    visited[nextX][nextY] = true;
			return true;
		}
		return false;
	}
}
