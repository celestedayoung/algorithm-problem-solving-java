import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    static Scanner sc;
    static StringTokenizer st;
    static int testNum;
    static int N;
    static int M;
    static int[][] flies;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        testNum = sc.nextInt();

        for (int t = 1; t <= testNum ; t++) {

            N = sc.nextInt();
            M = sc.nextInt();
            sc.nextLine();

            flies = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(sc.nextLine());
                for (int j = 0; j < N; j++) {
                    flies[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for (int r = 0; r <= N - M; r++) {
                for (int c = 0; c <= N - M; c++) {

                    int kill = 0;

                    for (int i = r; i < r + M; i++) {
                        for (int j = c; j < c + M; j++) {
                            kill += flies[i][j];
                        }
                    }
                    if (kill > max) {
                        max = kill;
                    }
                }
            }
            System.out.printf("#%d %d%n", t, max);

        }
    }
}
