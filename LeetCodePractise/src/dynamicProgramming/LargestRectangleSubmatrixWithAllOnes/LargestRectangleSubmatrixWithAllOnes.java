 package dynamicProgramming.LargestRectangleSubmatrixWithAllOnes;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleSubmatrixWithAllOnes {
	
	/*Approach 1 : Using logic of Largest Rectangle Under Histogram
	 * Time Complexity: m*n
	 * Space Complexity: m*n
	 */
	public int maximalRectangle(char[][] matrix) {
	      if(matrix == null){
	            return 0;
	        }
	        int m = matrix.length;
	        if(m == 0){
	            return 0;
	        }
	        int n = matrix[0].length;
	        int [][] resM = new int[m][n];  
	        
	        for(int i=0; i < n; i++){
	            if(matrix[0][i] == '0'){
	                resM[0][i] = 0;
	            }else{
	                 resM[0][i] = 1;
	            }
	        }
	        
	         for(int i=1; i < m; i++){
	            for(int j=0; j < n; j++){
	               if(matrix[i][j] == '1'){
	                   resM[i][j] = resM[i-1][j] + 1;
	               }else{
	                 resM[i][j] = 0;
	               }
	            }
	        }
	        int res = 0;
	        for(int i=0; i < m; i++){
	            int temp = largestRectangleArea(resM[i]);
	            res = Math.max(res, temp);
	        }
	        
	        return res;
	    }
	    
	    public int largestRectangleArea(int[] A) {
	        
	        Stack<Integer> s = new Stack<>();
	        int[] leftEnd = new int[A.length];
	        
	        for(int i=0; i < A.length; i++){
	            
	            while(!s.empty() && A[s.peek()] >= A[i]){
	                s.pop();
	            } 
	            leftEnd[i] = s.empty() ? 0 : (s.peek() + 1);
	            s.push(i);
	        }
	     
	        while(!s.empty()) s.pop();
	        
	        int[] rightEnd = new int[A.length];
	        
	        for(int i=A.length-1; i >= 0; i--){
	            
	            while(!s.empty() && A[s.peek()] >= A[i])
	                s.pop();
	                
	            rightEnd[i] = s.empty() ? A.length-1 : (s.peek() - 1);
	            
	            s.push(i);
	        }
	 
	        int maxarea = 0;
	        for(int i = 0; i < A.length; i++){
	            int area = (rightEnd[i] - leftEnd[i] + 1) * A[i];
	            maxarea = Math.max(maxarea, area);
	        }
	        
	        return maxarea;
	        
	    }
}
