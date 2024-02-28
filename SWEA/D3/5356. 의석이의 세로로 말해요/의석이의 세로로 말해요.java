import java.util.Scanner;

public class Solution {
	
	static Scanner sc;
	static char[] input;
	static char[][] words;
	static int maxLength;
	static String result;

	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		int testNum = sc.nextInt();
		sc.nextLine();
		
		for (int t = 1; t <= testNum; t++ ) {
			
			words = new char[5][];
			maxLength = 0;
			
			for (int i = 0; i < 5; i++) {
				input = sc.nextLine().toCharArray();
				words[i] = input;
				if (maxLength < input.length) {
					maxLength = input.length;
				}
			}
			
			result = "";
			for (int c = 0; c < maxLength; c++) {
				for (int r = 0; r < 5; r++) {
					if (c >= words[r].length) {
						continue;
					}
					result += words[r][c];
				}
			}
			System.out.printf("#%d %s%n", t, result);
		}
	}
}
