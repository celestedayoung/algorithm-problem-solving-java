import java.util.Scanner;

public class Solution {

	static Scanner sc;
	static int testNum;
	static String input;
	static int[] spade;
	static int[] diamond;
	static int[] heart;
	static int[] clover;
	static boolean flag;
	static String tmp;
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		testNum = sc.nextInt();
		sc.nextLine();
		
		for (int t = 1; t <= testNum; t++) {
			
			input = sc.nextLine();
			
			spade = new int[14];
			diamond = new int[14];
			heart = new int[14];
			clover = new int[14];
			
			flag = true;
			
			for (int i = 0; i < input.length() - 2; i++) {
				
				if (input.charAt(i) == 'S') {

					tmp = input.substring(i + 1, i + 3);

					if (spade[Integer.parseInt(tmp)] == 0) {
						spade[Integer.parseInt(tmp)]++;
					} else {
						flag = false;
						break;
					}
				} else if (input.charAt(i) == 'D') {
					tmp = input.substring(i + 1, i + 3);
					if (diamond[Integer.parseInt(tmp)] == 0) {
						diamond[Integer.parseInt(tmp)]++;
					} else {
						flag = false;
						break;
					}
				} else if (input.charAt(i) == 'H') {
					tmp = input.substring(i + 1, i + 3);
					if (heart[Integer.parseInt(tmp)] == 0) {
						heart[Integer.parseInt(tmp)]++;
					} else {
						flag = false;
						break;
					}
				} else if (input.charAt(i) == 'C') {
					tmp = input.substring(i + 1, i + 3);
					if (clover[Integer.parseInt(tmp)] == 0) {
						clover[Integer.parseInt(tmp)]++;
					} else {
						flag = false;
						break;
					}
				}
				
			}
			
			int spadeResult = -1;
			int diamondResult = -1;
			int heartResult = -1;
			int cloverResult = -1;
			
			for (int i = 0; i < 14; i++) {
				if (spade[i] == 0) {
					spadeResult++;
				}
				if (diamond[i] == 0) {
					diamondResult++;
				}
				if (heart[i] == 0) {
					heartResult++;
				}
				if (clover[i] == 0) {
					cloverResult++;
				}
			}
			
			
			if (flag) {
				System.out.printf("#%d %d %d %d %d%n", t, spadeResult, diamondResult, heartResult, cloverResult);				
			} else {
				System.out.printf("#%d %s%n", t, "ERROR");
			}
			
			
			
		}
		
	}

}
