 package dynamicProgramming.LargestSquareSubmatrixWithAllOnes;

import java.util.Arrays;

public class LargestSquareSubmatrixWithAllOnes {
	
	/*Approach 1 : DP
	 * Time Complexity: m*n
	 * Space Complexity: m*n
	 */
	 public int maximalSquare(char[][] matrix) {
	        if(matrix == null){
	            return 0;
	        }
	        int m = matrix.length;
	        if(m == 0){
	            return 0;
	        }
	        int n = matrix[0].length;
	        int [][] resM = new int[m][n];
	        int res = 0;
	        for(int i=0; i < n; i++){
	            if(matrix[0][i] == '0'){
	                resM[0][i] = 0;
	            }else{
	                 resM[0][i] = 1;
	            }
	            res = Math.max(res, resM[0][i]);
	        }
	        
	        for(int i=0; i < m; i++){
	             if(matrix[i][0] == '0'){
	                resM[i][0] = 0;
	            }else{
	                 resM[i][0] = 1;
	            }
	            res = Math.max(res, resM[i][0]);
	        }
	        
	        for(int i=1; i < m; i++){
	            for(int j=1; j < n; j++){
	               if(matrix[i][j] == '1'){
	                   int min = Math.min(resM[i][j-1], resM[i-1][j-1]);
	                   resM[i][j] = Math.min(min, resM[i-1][j]) + 1;
	               }else{
	                   resM[i][j] = 0;
	               }
	               res = Math.max(res, resM[i][j]);
	            }
	        }
	        return res*res;
	    }
}
