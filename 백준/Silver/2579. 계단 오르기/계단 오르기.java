import java.util.Scanner;

public class Main {
	
	static Scanner sc;
	static int N, sum;
	
	static int[] stairs = new int[301];
	static int[] d = new int[301];
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		sum = 0;
		
		for (int i = 1; i <= N; i++) {
			stairs[i] = sc.nextInt();
			sum += stairs[i];
		}
		
		if (N < 3) {
			System.out.println(sum);
		} else {
			
			d[1] = stairs[1];
			d[2] = stairs[2];
			d[3] = stairs[3];
			
			for (int i = 4; i <= N - 1; i++) {
				d[i] = Math.min(d[i - 2], d[i - 3]) + stairs[i];
				
			}
			System.out.println(sum - Math.min(d[N - 1], d[N - 2]));
		}
	}
}
