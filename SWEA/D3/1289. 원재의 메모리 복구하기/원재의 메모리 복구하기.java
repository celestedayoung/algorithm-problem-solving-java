import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int testNum = sc.nextInt();
		
		for (int t = 1; t <= testNum; t++) {
			
			String forLength = sc.next();
			
			int length = forLength.length();
			int[] testCase = new int[length];
			int[] initial = new int[length];
			
			for (int i = 0; i < length; i++) {
				testCase[i] = forLength.charAt(i) - '0';
			}
			
			int cnt = 0;
			for (int i = 0; i < length; i++) {
				
				if (testCase[i] != initial[i]) {
					cnt++;
					for (int j = i; j < length; j++) {
						initial[j] = testCase[i];
					}
				}
			}
			System.out.printf("#%d %d%n",t, cnt);
		}
	}	
}