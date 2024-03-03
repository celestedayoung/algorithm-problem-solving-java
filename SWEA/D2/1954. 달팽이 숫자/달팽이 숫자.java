import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();

        for (int t = 1; t <= testNum ; t++) {

            int N = sc.nextInt();
            int[][] snail = new int[N][N];
            snail[0][0] = 1;

            int r = 0;
            int c = 0;

            int[] dr = {0, 1, 0, -1};
            int[] dc = {1, 0, -1, 0};

            int pointer = 0;

            for (int i = 1; i < N * N; i++) {

                r += dr[pointer];
                c += dc[pointer];

                if (r >= N || r < 0 || c >= N || c < 0 || snail[r][c] != 0) {
                    r -= dr[pointer];
                    c -= dc[pointer];
                    if (pointer < 3) {
                        pointer++;
                    } else {
                        pointer = 0;
                    }
                    r += dr[pointer];
                    c += dc[pointer];
                }
                snail[r][c] = i + 1;
            }

            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(snail[i][j] + " ");
                }
                System.out.println();

            }
        }
    }
}
