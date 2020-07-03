package backtracking.NQueen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {
	
	public static void main(String args[]) 
    { 
		NQueen obj = new NQueen();
		List<List<String>> res  = obj.solve(4);
		
		System.out.println(res.size());
		for(List<String> a : res){
			for(String x : a){
				System.out.println(x);
			}
			System.out.println();
			System.out.println("******************************");
			System.out.println();
		}
	
		System.out.println(count);
    }

	/*
	 * Approach 1 : Backtracking
	 * Time Complexity: O(8^(m*n)) 
	 * Space Complexity: O(m*n)
	 */
	static int count = 0;
	private List<List<String>> solve(int n){
		List<List<String>> res = new ArrayList<>();
		char[][] matrix = new char[n][n];
		for(char[] row : matrix) {
			for(int j=0; j<n; j++) {
				row[j] = '.';
			}
		}
		nQueen(matrix, 0, res);
		return res;
	}
	private void nQueen(char [][] matrix, int row, List<List<String>> res) {
		count++;
		if(row == matrix.length){
			List<String> list = new ArrayList<String>();
	        for(int i = 0; i < matrix.length; i++) {
	            list.add(String.valueOf(matrix[i]));
	        }
			res.add(list);
			return;
		}else{
			for (int i = 0; i < matrix.length; i++) {
				if(isSafe(matrix, row, i)){
					matrix[row][i] = 'Q';
					nQueen(matrix, row+1, res);
					matrix[row][i] = '.';
				}
			}
		}
	}

	private boolean isSafe(char [][] matrix, int row, int col) {
		for (int i = 0; i < row; i++) {
			if(matrix[i][col] == 'Q'){
				return false;
			}
			for (int j = 0; j < matrix[0].length; j++) {
				if( matrix[i][j] == 'Q'){
					if(i-j == row-col || i+j == row+col){
						return false;
					}
				}
			}
		}
		return true;
	}
}
