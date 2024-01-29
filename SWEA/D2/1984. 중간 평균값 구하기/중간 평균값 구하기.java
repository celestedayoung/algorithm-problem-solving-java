import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int[] nums = new int[10];
            
           for (int n = 0; n < 10; n++) {
				nums[n] = sc.nextInt();
			}
			
			for (int i = 0; i < nums.length - 1; i++) {
				for (int j = 0; j < nums.length - 1 - i; j++) {
					
					if (nums[j] > nums[j + 1]) {
						
						int tmp = nums[j];
						nums[j] = nums[j + 1];
						nums[j + 1] = tmp;
					}
					
				}
			}
			
			int sum = 0;
			for (int s = 1; s < nums.length - 1; s++) {
				sum += nums[s];
			}
			
			double avg = (double) sum / (nums.length - 2);
			
			System.out.printf("#%d %.0f%n", t, avg);
		}
	}
}