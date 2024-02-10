import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int testNum = sc.nextInt();

            char[][] board = new char[100][];

            for (int i = 0; i < 100; i++) {
                String stringRow = sc.next();
                board[i] = stringRow.toCharArray();
            }

            int rowMax = rowPalindrome(board);
            int colMax = colPalindrome(board);

            int result = (rowMax <= colMax) ? colMax : rowMax;

            System.out.printf("#%d %d%n", testNum, result);

        }
    }

    public static int colPalindrome(char[][] charArr) {

        int max = Integer.MIN_VALUE;

        // palindrome의 길이가 홀수인 경우
        for (int c = 0; c < charArr.length; c++) {
            for (int i = 0; i < charArr[c].length; i++) {

                int idx = 0;

                while (true) {
                    idx++;
                    if (i - idx >= 0 && i + idx < charArr[c].length) {
                        if (charArr[i - idx][c] == charArr[i + idx][c]) {

                            int length = 2 * idx + 1;

                            if (max <= length) {
                                max = length;
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

                            if (max <= length) {
                                max = length;
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
        return max;

    }

    public static int rowPalindrome(char[][] charArr) {

        int max = Integer.MIN_VALUE;

        for (int r = 0; r < charArr.length; r++) {

            // palindrome의 길이가 홀수인 경우
            for (int i = 0; i < charArr[r].length; i++) {

                int idx = 0;

                while (true) {
                    idx++;

                    if (i - idx >= 0 && i + idx < charArr[r].length) {
                        if (charArr[r][i - idx] == charArr[r][i + idx]) {

                            int length = 2 * idx + 1;

                            if (max <= length) {
                                max = length;
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

                            if (max <= length) {
                                max = length;
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
        return max;
    }
}