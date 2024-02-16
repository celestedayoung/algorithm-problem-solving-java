import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int testNum = sc.nextInt();
		
		for (int t = 1; t <= testNum; t++) {
		
			int numsLength = sc.nextInt();
			int[] numsArr = new int[numsLength];
			
			for (int n = 0; n < numsLength; n++) {
				numsArr[n] = sc.nextInt();
 			}
			
			int max = -1;
			for (int i = 0; i < numsLength - 1; i++) {
				for (int j = i + 1; j < numsLength; j++) {
					
					int number = numsArr[i] * numsArr[j];
					String numberToConfirm = number + "";
					
					for (int k = 0; k < numberToConfirm.length() - 1; k++) {
						if (numberToConfirm.charAt(k) > numberToConfirm.charAt(k + 1)) {
							break;
						} else if (k == numberToConfirm.length() - 2) {
							
							int result = Integer.parseInt(numberToConfirm);
							if (max < result) {
								max = result;
							}
						}
					}
					
				}
			}
			System.out.printf("#%d %d%n", t, max);	
		}
	}
}
