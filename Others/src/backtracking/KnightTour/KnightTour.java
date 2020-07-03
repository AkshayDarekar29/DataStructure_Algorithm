package backtracking.KnightTour;

import java.util.Arrays;

public class KnightTour {
	
	public static void main(String args[]) 
    { 
		KnightTour obj = new KnightTour();
		int [][] matrix = new int[6][6];
		int xStart = 0;
		int yStart = 0;
		boolean f = obj.solve(matrix, xStart, yStart);
		if(f){
			for (int i = 0; i < matrix.length; i++) {
				System.out.println(Arrays.toString(matrix[i]));
			}
		}else{
			System.out.println("Solution does not exist");
		}
    }

	/*
	 * Approach 1 : Backtracking
	 * Time Complexity: O(8^(m*n)) 
	 * Space Complexity: O(m*n)
	 */
	private boolean solve(int[][] matrix, int xStart, int yStart){
		int m = matrix.length;
		int n= matrix[0].length;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = -1;
			}
		}
		matrix[xStart][yStart] = 0;
		int [] xMove = {2,1,-1,-2,-2,-1,1,2}; 
		int [] yMove = {1,2,2,1,-1,-2,-2,-1}; 
		if(KniteTour(matrix, xStart, yStart, 1, xMove, yMove)){
			return true;
		}
		return false;
	}
	private boolean KniteTour(int[][] matrix, int x, int y, int move, int[] xMove, int[] yMove) {
		int nextX;
		int nextY;
	
		if(move == matrix.length * matrix[0].length){
			return true;
		}
		
		for (int i = 0; i < xMove.length; i++) {
			nextX = x + xMove[i];
			nextY = y + yMove[i];
			if(isSafe(nextX, nextY, matrix)){
				matrix[nextX][nextY] = move;
				if(KniteTour(matrix, nextX, nextY, move+1, xMove, yMove)){
					return true;
				}else{
					matrix[nextX][nextY] = -1;
				}
			}
			
		}
		return false;
	}

	private boolean isSafe(int nextX, int nextY, int[][] matrix) {
		
		if(nextX >= 0 && nextX < matrix.length && nextY >= 0 && nextY < matrix[0].length && matrix[nextX][nextY] == -1){
			return true;
		}
		return false;
	}	
}
