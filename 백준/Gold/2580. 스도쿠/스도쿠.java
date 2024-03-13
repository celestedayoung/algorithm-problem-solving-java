import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		
		board = new int[9][9];
		for (int r = 0; r < 9; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 9; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		sudoku(0, 0);
		
		
	}
	
	static boolean voidNum (int row, int col, int number) {

		for(int i = 0 ; i < 9 ; i ++) {
			if(board[row][i] == number) {
				return false;
			}
		}
		
		for(int i = 0 ; i < 9 ; i ++) {
			if(board[i][col] == number) {
				return false;
			}
		}
		
		int ind_row = (row/3)*3;
		int ind_col = (col/3)*3;
		
		for(int i = ind_row ; i < ind_row+3 ; i ++) {
			for(int j = ind_col ; j < ind_col +3 ; j++) {
				if(board[i][j] == number)
					return false;
			}
		}
		
		return true;
	}
	
	static void sudoku(int row, int col) {
		
		if (col == 9) {
			sudoku(row + 1, 0);
			return;
		}
		
		if (row == 9) {
			 for (int r = 0; r < 9; r++) {
				 for (int c = 0; c < 9; c++) {
					 System.out.print(board[r][c] + " ");
				 }
				 System.out.println();
			 }
			 System.exit(0);
		 }
		
		if (board[row][col] == 0) {
			for(int i = 1 ; i <= 9 ; i++) {
				if(voidNum(row, col, i)) {
					board[row][col] = i;
					sudoku(row, col+1);
				}
			}
			board[row][col]=0;
			return;
		}
		
		sudoku(row, col + 1);
		
		
	
	}
}
