import java.util.Scanner;

public class Solution {

    static Scanner sc;
    static int testNum;
    static int N;
    static String input;
    static char[] inputArr;
    static char[][] board;
    static boolean flag;
    static int cnt;

    public static void main(String[] args) {

        sc = new Scanner(System.in);

        testNum = sc.nextInt();

        for (int t = 1; t <= testNum ; t++) {

            N = sc.nextInt();
            sc.nextLine();

            board = new char[N][N];
            for (int r = 0; r < N; r++) {

                input = sc.nextLine();
                inputArr = input.toCharArray();

                for (int c = 0; c < N; c++) {
                    board[r][c] = inputArr[c];
                }
            }

            int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
            int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

            flag = false;

            out: for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {

                    if (board[r][c] == 'o') {

                        for (int d = 0; d < 8; d++) {
                            
                            cnt = 1;
                            
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            while (nr >= 0 && nc >= 0 && nr < N && nc < N) {
                                if (board[nr][nc] == 'o') {
                                    cnt++;
                                    if (cnt >= 5) {
                                        flag = true;
                                        break out;
                                    }
                                } else {
                                    break ;
                                }
                                nr += dr[d];
                                nc += dc[d];
                            }
                        }

                    }
                }
            }

            System.out.printf("#%d %s%n", t, flag ? "YES" : "NO");

        }
    }
}
