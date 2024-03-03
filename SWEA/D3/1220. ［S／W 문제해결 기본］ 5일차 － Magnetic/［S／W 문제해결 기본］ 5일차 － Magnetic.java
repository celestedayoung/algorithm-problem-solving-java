import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    static Scanner sc;
    static StringTokenizer st;
    static int N;
    static String[][] board;
    static int result;
    static boolean poleN;
    static boolean poleS;

    public static void main(String[] args) {

        sc = new Scanner(System.in);

        for (int t = 1; t <= 10 ; t++) {
            N = sc.nextInt();
            sc.nextLine();

            board = new String[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(sc.nextLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = st.nextToken();
                }
            }

            result = 0;

            for (int c = 0; c < N; c++) {

                poleN = false;

                for (int r = 0; r < N; r++) {
                    if (board[r][c].equals("1")) {
                        poleN = true;
                    } else if (poleN && board[r][c].equals("2")) {
                        result++;
                        poleN = false;
                    }
                }
            }
            System.out.printf("#%d %d%n", t, result);
        }
    }

}
