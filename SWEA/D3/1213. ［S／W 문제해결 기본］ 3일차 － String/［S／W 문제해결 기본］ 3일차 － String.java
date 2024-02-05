import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			int testNum = sc.nextInt();
			
			String word = sc.next();
			String sentence = sc.next();
			
			int cnt = 0;
			for (int i = 0; i < sentence.length() - word.length() + 1; i++) {
				
				if (sentence.charAt(i) == word.charAt(0)) {
					
					String tmp = sentence.substring(i, i + word.length());
					
					out: for (int j = 0; j < tmp.length(); j++) {
						if (tmp.charAt(j) == word.charAt(j)) {
							if (j == tmp.length() - 1) {
								cnt++;
							}
						} else {
							break out;
						}
					}
				}
			}
			System.out.printf("#%d %d%n", testNum, cnt);
		}
	}
}