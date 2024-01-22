import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String seats = sc.next();

        int cntS = 0;
        int cntL = 0;

        for (int i = 0; i < N; i++) {
            if (seats.charAt(i) == 'S') {
                cntS++;
            } else {
                cntL++;
            }
        }
        
        if (cntS != N) {
        	System.out.println(cntS + cntL - (cntL / 2) + 1);
        } else {
        	System.out.println(cntS);
        }
        

    }
}