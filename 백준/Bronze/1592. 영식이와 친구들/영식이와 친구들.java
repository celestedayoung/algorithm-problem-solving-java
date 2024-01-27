import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();

        int cnt = 0;
        int[] ballCnt = new int[N];
        ballCnt[0] = 0;
        int i = 0;

        while (ballCnt[0] < M) {
            if (i >= N) {
                i = i - N;
            } else if (i < 0) {
                i = i + N;
            }

            if (ballCnt[i] % 2 != 0) {
                ballCnt[i] += 1;
            } else {
                ballCnt[i] += 1;
            }
            i = i + L;
            cnt++;
        }
        System.out.println(cnt - 1);
    }
}