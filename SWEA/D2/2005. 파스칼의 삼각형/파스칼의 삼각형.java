import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			
			int row = sc.nextInt();
			int[][] triangle = new int[row][];
			
			for (int r = 0; r < row; r++) {
				triangle[r] = new int[r + 1];
			}
			
			for (int r = 0; r < row; r++) {
				for (int c = 0; c <= r; c++) {
					
					if (r < 2) {
						triangle[r][c] = 1;
					} else if (c == 0 || c == r) {
						triangle[r][c] = 1;
					} else if (c > 0 && c < r) {
						triangle[r][c] = triangle[r - 1][c - 1] + triangle[r - 1][c];
					}
				}
			}
			System.out.println("#" + t);
			for (int i = 0; i < row; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(triangle[i][j] + " ");
				}
				System.out.println();
			} 
		}
	}
}
