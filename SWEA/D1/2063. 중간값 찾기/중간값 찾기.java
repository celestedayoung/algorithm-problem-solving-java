import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] score = new int[N];
		
		for (int i = 0; i < N; i++) {
			score[i] = sc.nextInt();
		}
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				
				if (score[i] > score[j]) {
					int tmp = score[i];
					score[i] = score[j];
					score[j] = tmp;
				}
			}
		}
		System.out.println(score[N/2]);
	}
}