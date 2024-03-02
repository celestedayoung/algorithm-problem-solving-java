import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    static Scanner sc;
    static StringTokenizer st;
    static int testNum;
    static int N;
    static String[][] reservoir;
    static int max;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        testNum = sc.nextInt();

        for (int t = 1; t <= testNum ; t++) {

            N = sc.nextInt();
            sc.nextLine();

            reservoir = new String[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(sc.nextLine());
                for (int j = 0; j < N; j++) {
                    reservoir[i][j] = st.nextToken();
                }
            }

            max = 0;
            for (int i = 0; i <= N - 3; i++) {
                for (int j = 0; j <= N - 3; j++) {
                    if (max < depth(reservoir, i, j)) {
                        max = depth(reservoir, i, j);
                    }
                }
            }
            System.out.printf("#%d %d%n", t, max);
        }
    }

    public static int depth(String[][] reservoir, int i, int j) {

        int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
        int max = 0;

        for (int r = i; r < i + 3; r++) {
            for (int c = j; c < j + 3; c++) {
                int cnt = 0;
                for (int d = 0; d < 8; d++) {

                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr >= 0 && nr < reservoir.length && nc >= 0 && nc < reservoir.length) {
                        if (reservoir[nr][nc].equals("W")) {
                            cnt++;
                        }
                    }
                }
                if (max < cnt) {
                    max = cnt;
                }
            }
        }
        if (max > 0) {
            return max;
        } else {
            return 1;
        }
    }
}
