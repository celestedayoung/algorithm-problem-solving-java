import java.util.Scanner;

public class Solution {
	
	static Scanner sc;
	static int testNum, N;
	static int[] cnt;
	static int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		testNum = sc.nextInt();
		
		for (int t = 1; t <= testNum; t++) {
			
			N = sc.nextInt();
			
			cnt = new int[money.length];
			
				
			for (int i = 0; i < money.length; i++) {
				
				cnt[i] = N / money[i];
				N = N % money[i];
				
			}
			
			System.out.println("#"+ t);
			for (int i = 0; i < cnt.length; i++) {
				System.out.print(cnt[i] + " ");
			}
			System.out.println();
		}
	}

}
