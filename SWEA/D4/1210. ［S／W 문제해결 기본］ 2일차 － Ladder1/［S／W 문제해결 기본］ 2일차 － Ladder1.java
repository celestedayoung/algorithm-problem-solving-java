import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int r = 0; r < 10; r++) {
            int testNum = sc.nextInt();
            int[][] ladder = new int[100][100];

            // 사다리 입력 받기
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = sc.nextInt();
                }
            }

            int colPoint = 0;
            // 2가 위치하는 열 찾기
            for (int i = 0; i < 100; i++) {
                if (ladder[99][i] == 2) {
                    colPoint = i;
                    break;
                }
            }

            int rowPoint = 99;  // 가장 아래 행에서 시작

            while (rowPoint > 0) {
                // 좌우로 이동
                if (colPoint > 0 && ladder[rowPoint][colPoint - 1] == 1) {
                    // 왼쪽으로 이동
                    colPoint--;
                    while (rowPoint > 0 && ladder[rowPoint - 1][colPoint] == 0) {
                        colPoint--;
                    }
                } else if (colPoint < 99 && ladder[rowPoint][colPoint + 1] == 1) {
                    // 오른쪽으로 이동
                    colPoint++;
                    while (rowPoint > 0 && ladder[rowPoint - 1][colPoint] == 0) {
                        colPoint++;
                    }
                }
                rowPoint--;
            }

            System.out.println("#" + testNum + " " + colPoint);
        }
    }
}