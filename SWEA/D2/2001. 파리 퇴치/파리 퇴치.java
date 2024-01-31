import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int testNum = sc.nextInt();
		
		for (int t = 1; t <= testNum; t++) {
			
			int N = sc.nextInt();
			int killRange = sc.nextInt();
			
			int[][] fly = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					fly[i][j] = sc.nextInt();
				}	
			}
			
			List<Integer> sumList = new ArrayList<Integer>();
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					
					int sum = 0;
					
					for (int nr = 0; nr < killRange; nr++) {
						for (int nc = 0; nc < killRange; nc++) {
							if (r + nr < N && c + nc < N) {
								sum += fly[r + nr][c + nc];
							}
						
							
						}
					}
					sumList.add(sum);
				}
			}
			
			int max = -1;
			
			for (int i = 0; i < sumList.size(); i++) {
				if (max < sumList.get(i)) {
					max = sumList.get(i);
				}
			}
			System.out.printf("#%d %d%n", t, max);
		}
	}
}