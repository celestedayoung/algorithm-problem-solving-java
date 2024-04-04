import java.util.Scanner;

public class Main {
	
	static Scanner sc;
	static int testNum, N, cnt;
	
	static int[] d = new int[20];
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		testNum = sc.nextInt();
		
		for (int t = 0; t < testNum; t++) {
			
			N = sc.nextInt();
			
			d[1] = 1;
			d[2] = 2;
			d[3] = 4;
			
			for (int i = 4; i < 11; i++) {
				d[i] = d[i - 1] + d[i - 2] + d[i - 3];
			}
			
			System.out.println(d[N]);
		}
	}

}
