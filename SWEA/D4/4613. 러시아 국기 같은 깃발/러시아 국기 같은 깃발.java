import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	
	static int row;
	static int col;
	static int cnt;
	
	static char[][] flag;
	static String forFlag;
	static char[] forFlagArr;
	
	public static void main(String[] args) throws IOException {
		
	  Scanner sc = new Scanner(System.in);
		
      //File file = new File("./swea/swea_4613_러시아국기같은깃발/input.txt");
      //Scanner sc = new Scanner(file);
	
		int testNum = sc.nextInt();
		
		for (int t = 1; t <= testNum; t++) {
			
			row = sc.nextInt();
			col = sc.nextInt();

			flag = new char[row][col];
			
			for (int r = 0; r < row; r++) {
				
				forFlag = sc.next();
				forFlagArr = forFlag.toCharArray();
				
				for (int c = 0; c < col; c++) {
					flag[r][c] = forFlagArr[c];
				}
			}
			
			int min = Integer.MAX_VALUE;
			for (int firstRow = 1; firstRow < row - 1; firstRow++) {
				for (int secondRow = firstRow + 1; secondRow < row; secondRow++) {
					cnt = 0;
					min = Math.min(paintCnt(firstRow, secondRow), min);
				}
			}
			
			System.out.printf("#%d %d%n", t, min);
		}
	}
	
	public static int paintCnt(int row1, int row2) {
		
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				
				if (r < row1 && flag[r][c] != 'W') {
					cnt++;
				} else if (r >= row1 && r < row2 && flag[r][c] != 'B') {
					cnt++;
				} else if (r >= row2 && flag[r][c] != 'R') {
					cnt++;
				}
			}
		}
		
		return cnt;
	}
}
