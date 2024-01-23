import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			long[] money = new long[N];
			
			for (int n = 0; n < N; n++) {
				money[n] = sc.nextLong();
			}
			
			long max = money[N - 1];
			long answer = 0;
			
			for (int i = N - 1; i >= 0; i--) {
				if (max > money[i]) {
					answer += max - money[i];
				} else {
					max = money[i];
				}
			}
			System.out.printf("#%d %d%n", t, answer);
		}
	}
}