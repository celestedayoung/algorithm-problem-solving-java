import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    static Scanner sc;
    static StringTokenizer st;
    static int testNum;
    static int N;
    static String[][] arr;
    static String[][] arr90;
    static String[][] arr180;
    static String[][] arr270;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        testNum = sc.nextInt();

        for (int t = 1; t <= testNum; t++) {

            N = sc.nextInt();
            sc.nextLine();

            arr = new String[N][N];
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(sc.nextLine());
                for (int c = 0; c < N; c++) {
                    arr[r][c] = st.nextToken();
                }
            }

            arr90 = new String[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    arr90[c][(N - 1) - r] = arr[r][c];
                }
            }

            arr180 = new String[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    arr180[c][(N - 1) - r] = arr90[r][c];
                }
            }

            arr270 = new String[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    arr270[c][(N - 1) - r] = arr180[r][c];
                }
            }

            System.out.printf("#%d%n", t);
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    System.out.print(arr90[r][c]);
                }
                System.out.print(" ");
                for (int c = 0; c < N; c++) {
                    System.out.print(arr180[r][c]);
                }
                System.out.print(" ");
                for (int c = 0; c < N; c++) {
                    System.out.print(arr270[r][c]);
                }
                System.out.println();

            }
        }
    }
}
