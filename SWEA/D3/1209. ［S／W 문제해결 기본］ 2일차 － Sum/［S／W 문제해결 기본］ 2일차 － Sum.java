import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			
			int testNum = sc.nextInt();
			
			int[][] testArr = new int[100][100];
			int[] sumList = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
			
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					testArr[r][c] = sc.nextInt();
				}
			}
			
			// 0. 행 우선 순회
			for (int r = 0; r < 100; r++) {
				int sum = 0;
				for (int c = 0; c < 100; c++) {
					sum += testArr[r][c];
				}
				if (sumList[0] < sum) {
					sumList[0] = sum;
				}
			}
				
			// 1. 열 우선 순회
			for (int c = 0; c < 100; c++) {
				int sum = 0;
				for (int r = 0; r < 100; r++) {
					sum += testArr[r][c];
				}
				if (sumList[1] < sum) {
					sumList[1] = sum;
				}
			}
			
			// 2-1. 대각선 순회
			for (int i = 0; i < 100; i++) {
				int sum = 0;
				sum += testArr[i][i];
				
				if (sumList[2] < sum) {
					sumList[2] = sum;
				}
			}
			
			// 2-2. 대각선 순회
			for (int i = 99; i >= 0; i--) {
				int sum = 0;
				sum += testArr[i][i];
				
				if (sumList[3] < sum) {
					sumList[3] = sum;
				}
			}
			
			int max = Integer.MIN_VALUE;
			
			for (int m = 0; m < 4; m++) {
				if (max < sumList[m]) {
					max = sumList[m];
				}
			}
			System.out.printf("#%d %d%n", testNum, max);
		}
	}
}