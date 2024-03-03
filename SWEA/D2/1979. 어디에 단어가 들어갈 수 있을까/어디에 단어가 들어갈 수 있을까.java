import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    static Scanner sc;
    static StringTokenizer st;
    static int testNum;
    static int N;
    static int wordLength;
    static String[][] board;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        testNum = sc.nextInt();

        for (int t = 1; t <= testNum ; t++) {

            N = sc.nextInt();
            wordLength = sc.nextInt();
            sc.nextLine();

            board = new String[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(sc.nextLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = st.nextToken();
                }
            }
            int result = checkRow(board) + checkCol(board);

            System.out.printf("#%d %d%n", t, result);
        }
    }

    public static int checkRow(String[][] board) {

        int result = 0;

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (board[i][j].equals("1")) {
                    cnt++;
                } else {
                    if (cnt < wordLength || cnt > wordLength) {
                        cnt = 0;
                    } else if (cnt == wordLength) {
                        result++;
                        cnt = 0;
                    }
                }
            }

            if (cnt == wordLength) {
                result++;
            }

        }
        return result;
    }
    public static int checkCol(String[][] board) {

        int result = 0;

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {

                if (board[j][i].equals("1")) {
                    cnt++;
                } else {
                    if (cnt < wordLength || cnt > wordLength) {
                        cnt = 0;
                    } else if (cnt == wordLength) {
                        result++;
                        cnt = 0;
                    }
                }
            }

            if (cnt == wordLength) {
                result++;
            }
        }
        return result;
    }
}
