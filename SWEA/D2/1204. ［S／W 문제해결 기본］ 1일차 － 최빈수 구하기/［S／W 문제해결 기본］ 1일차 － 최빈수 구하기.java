import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int testNum = sc.nextInt();
			
			int[] score = new int[1000];
			int[] cnt = new int[101];
			
			for (int i = 0; i < 1000; i++) {
				score[i] = sc.nextInt();
			}
			
			for (int i = 0; i < 1000; i++) {
				cnt[score[i]]++;
			}
			
			int max = 0;
			int maxIdx = 0;
			for (int i = 0; i < cnt.length; i++) {
				if (max <= cnt[i]) {
					max = cnt[i];
					maxIdx = i;
				}
			}
			System.out.printf("#%d %d%n", t, maxIdx);
		}
	}
}