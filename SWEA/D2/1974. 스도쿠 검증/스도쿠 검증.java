import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    static Scanner sc;
    static StringTokenizer st;
    static int testNum;
    static int[][] board;
    static int[] check;
    static boolean flag;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        testNum = sc.nextInt();
        sc.nextLine();

        for (int t = 1; t <= testNum ; t++) {

            board = new int[9][9];
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(sc.nextLine());
                for (int j = 0; j < 9; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            flag = true;

            // row direction
            if (flag) {
                out: for (int r = 0; r < 9; r++) {
                    check = new int[10];
                    for (int c = 0; c < 9; c++) {
                        if (check[board[r][c]] == 0) {
                            check[board[r][c]]++;
                        } else {
                            flag = false;
                            break out;
                        }
                    }
                }
            }

            if (flag) {
                out: for (int c = 0; c < 9; c++) {
                    check = new int[10];
                    for (int r = 0; r < 9; r++) {
                        if (check[board[r][c]] == 0) {
                            check[board[r][c]]++;
                        } else {
                            flag = false;
                            break out;
                        }
                    }
                }
            }

            if (flag) {
                out: for (int i = 0; i < 7; i+=3) {
                    for (int j = 0; j < 7; j+=3) {
                        check = new int[10];
                        for (int r = i; r < i + 3; r++) {
                            for (int c = j; c < j + 3; c++) {
                                if (check[board[r][c]] == 0) {
                                    check[board[r][c]]++;
                                } else {
                                    flag = false;
                                    break out;
                                }
                            }
                        }
                    }
                }
            }
            System.out.printf("#%d %d%n", t, flag ? 1 : 0);
        }

    }
}
