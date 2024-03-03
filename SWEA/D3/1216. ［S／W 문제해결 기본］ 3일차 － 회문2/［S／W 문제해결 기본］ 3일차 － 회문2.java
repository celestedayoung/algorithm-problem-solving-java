import java.util.Scanner;

public class Solution {
    static Scanner sc;
    static int testNum;
    static String input;
    static char[][] board;

    public static void main(String[] args) {

        sc = new Scanner(System.in);

        for (int t = 1; t <= 10 ; t++) {

            testNum = sc.nextInt();
            sc.nextLine();

            board = new char[100][100];

            for (int i = 0; i < 100; i++) {
                input = sc.nextLine();
                for (int j = 0; j < 100; j++) {
                    board[i][j] = input.charAt(j);
                }
            }

            int max = -1;

            // row direction
            // palindromes' length % 2 == 0
            // palindromes' length % 2 != 0
            for (int r = 0; r < 100; r++) {
                for (int c = 0; c < 100; c++) {

                    int pointer1 = 1;
                    while (c - pointer1 >= 0 && c + pointer1 < 100 && board[r][c - pointer1] == board[r][c + pointer1]) {
                        int length = 1 + 2 * pointer1;
                        if (length > max) {
                            max = length;
                        }
                        pointer1++;
                    }

                    int pointer2 = 0;
                    while (c - 1 - pointer2 >= 0 && c + pointer2 < 100 && board[r][c - 1 - pointer2] == board[r][c + pointer2]) {
                        int length = (pointer2 + 1) * 2;
                        if (length > max) {
                            max = length;
                        }
                        pointer2++;
                    }
                }
            }

            // col direction
            // palindromes' length % 2 == 0
            // palindromes' length % 2 != 0
            for (int r = 0; r < 100; r++) {
                for (int c = 0; c < 100; c++) {

                    int pointer1 = 1;
                    while (r - pointer1 >= 0 && r + pointer1 < 100 && board[r - pointer1][c] == board[r + pointer1][c]) {
                        int length = 1 + 2 * pointer1;
                        if (length > max) {
                            max = length;
                        }
                        pointer1++;
                    }

                    int pointer2 = 0;
                    while (r - 1 - pointer2 >= 0 && r + pointer2 < 100 && board[r - 1 - pointer2][c] == board[r + pointer2][c]) {
                        int length = (pointer2 + 1) * 2;
                        if (length > max) {
                            max = length;
                        }
                        pointer2++;
                    }
                }
            }
            System.out.printf("#%d %d%n", testNum, max);
        }
    }
}
