import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int findLength = sc.nextInt();

            char[][] board = new char[8][];

            for (int i = 0; i < 8; i++) {
                String stringRow = sc.next();
                board[i] = stringRow.toCharArray();
            }

            int rowResult = rowPalindrome(board, findLength);
            int colResult = colPalindrome(board, findLength);
            int result = rowResult + colResult;

            System.out.printf("#%d %d%n", t, result);

        }
    }

    public static int colPalindrome(char[][] charArr, int findLength) {

        int cnt = 0;

        // palindrome의 길이가 홀수인 경우
        for (int c = 0; c < charArr.length; c++) {
            for (int i = 0; i < charArr[c].length; i++) {

                int idx = 0;

                while (true) {
                    idx++;
                    if (i - idx >= 0 && i + idx < charArr[c].length) {
                        if (charArr[i - idx][c] == charArr[i + idx][c]) {

                            int length = 2 * idx + 1;

                            if (findLength == length) {
                                cnt++;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }

            // palindrome의 길이가 짝수인 경우
            for (int i = 0; i < charArr[c].length; i++) {

                int idx = -1;

                while (true) {
                    idx++;
                    if (i - idx - 1 >= 0 && i + idx < charArr[c].length) {
                        if (charArr[i - idx - 1][c] == charArr[i + idx][c]) {

                            int length = 2 * (idx+1);

                            if (findLength == length) {
                                cnt++;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return cnt;

    }

    public static int rowPalindrome(char[][] charArr, int findLength) {

        int cnt = 0;

        for (int r = 0; r < charArr.length; r++) {

            // palindrome의 길이가 홀수인 경우
            for (int i = 0; i < charArr[r].length; i++) {

                int idx = 0;

                while (true) {
                    idx++;

                    if (i - idx >= 0 && i + idx < charArr[r].length) {
                        if (charArr[r][i - idx] == charArr[r][i + idx]) {

                            int length = 2 * idx + 1;

                            if (findLength == length) {
                                cnt++;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }

            // palindrome의 길이가 짝수인 경우
            for (int i = 0; i < charArr[r].length; i++) {

                int idx = -1;

                while (true) {
                    idx++;
                    if (i - idx - 1 >= 0 && i + idx < charArr[r].length) {
                        if (charArr[r][i - idx - 1] == charArr[r][i + idx]) {

                            int length = 2 * (idx+1);

                            if (findLength == length) {
                                cnt++;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return cnt;
    }
}
