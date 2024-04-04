import java.util.Scanner;

public class Main {
	
	static Scanner sc;
	
	static int[] d = new int[1000001];
	static int N;
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		d[1] = 0;
		
		for (int i = 2; i <= N; i++) {
			d[i] = d[i - 1] + 1;
			
			if (i % 2 == 0) {
				d[i] = Math.min(d[i], d[i / 2] + 1);
			}
			
			if (i % 3 == 0) {
				d[i] = Math.min(d[i], d[i / 3] + 1);
			}
		}
		
		System.out.println(d[N]);
		
		
		
		
	}

}
