package backtracking.SudokuSolver;



public class SudokuSolver {
	public static void main(String[] args) {
		SudokuSolver obj = new SudokuSolver();
		char [][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}};
		obj.solveSudoku(board);
		System.out.println(board);
		
	}
	public void solveSudoku(char[][] board) {
        solveSudoku2(board);
    }
    public boolean solveSudoku2(char[][] board) {

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char k = '1'; k <= '9'; k++){
                        if(isSafe(board,i,j, k)){
                            board[i][j] = k;
                            if(solveSudoku2(board)){
                            	return true;
                            }else{
                            	board[i][j] = '.';
                            }   
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isSafe(char [][] board, int x, int y, int num){
    	/* Better Approach
    	 *  for(int i = 0; i < 9; i++) {
	            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
	            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
	            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
	            		board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
		        }
	        return true;
        */
        for(int i=0; i< board[0].length; i++){
            if(board[x][i] == num){
                return false;
            }
        }
        for(int i=0; i< board.length; i++){
            if(board[i][y] == num){
                return false;
            }
        }
        if(x >= 0 && x <= 2 && y >= 0 && y <= 2){
            for(int i=0; i<= 2; i++){
                for(int j=0; j<=2; j++){
                    if(board[i][j] == num){
                        return false;
                    }
                }
            }
        }else if(x >= 0 && x <= 2 && y >= 3 && y <= 5){
            for(int i=0; i<= 2; i++){
                for(int j=3; j<=5; j++){
                    if(board[i][j] == num){
                        return false;
                    }
                }
            }
        }else if(x >= 0 && x <= 2 && y >= 6 && y <= 8){
            for(int i=0; i<= 2; i++){
                for(int j=6; j<=8; j++){
                    if(board[i][j] == num){
                        return false;
                    }
                }
            }
        }else if(x >= 3 && x <= 5 && y >= 0 && y <= 2){
            for(int i=3; i<= 5; i++){
                for(int j=0; j<=2; j++){
                    if(board[i][j] == num){
                        return false;
                    }
                }
            }
        }else if(x >= 3 && x <= 5 && y >= 3 && y <= 5){
            for(int i=3; i<= 5; i++){
                for(int j=3; j<=5; j++){
                    if(board[i][j] == num){
                        return false;
                    }
                }
            }
        }else if(x >= 3 && x <= 5 && y >= 6 && y <= 8){
            for(int i=3; i<= 5; i++){
                for(int j=6; j<=8; j++){
                    if(board[i][j] == num){
                        return false;
                    }
                }
            }
        }else if(x >= 6 && x <= 8 && y >= 0 && y <= 2){
            for(int i=6; i<= 8; i++){
                for(int j=0; j<=2; j++){
                    if(board[i][j] == num){
                        return false;
                    }
                }
            }
        }else if(x >= 6 && x <= 8 && y >= 3 && y <= 5){
            for(int i=6; i<= 8; i++){
                for(int j=3; j<=5; j++){
                    if(board[i][j] == num){
                        return false;
                    }
                }
            }
        }else if(x >= 6 && x <= 8 && y >= 6 && y <= 8){
            for(int i=6; i<= 8; i++){
                for(int j=6; j<=8; j++){
                    if(board[i][j] == num){
                        return false;
                    }
                }
            }
        }
        return true;
   }
}
