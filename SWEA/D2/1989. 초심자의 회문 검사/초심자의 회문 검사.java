import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			
			String letters = sc.next();
			char[] lettersArr = letters.toCharArray();
			
			int flag = 1;
			
			out: for (int i = 0; i < lettersArr.length / 2; i++) {
				if (lettersArr[i] != lettersArr[lettersArr.length - 1 - i]) {
					flag = 0;
					break out;
				}
			}
			System.out.printf("#%d %d%n", t, flag);
		}
	}
}
