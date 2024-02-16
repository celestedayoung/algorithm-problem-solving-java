import java.util.Scanner;

public class Solution {
    static String forInput;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testNum = sc.nextInt();

        for (int t = 1; t <= testNum; t++) {

            int farmLength = sc.nextInt();
            int[][] farm = new int[farmLength][farmLength];

            for (int r = 0; r < farmLength; r++) {
                forInput = sc.next();
                for (int c = 0; c < farmLength; c++) {
                    farm[r][c] = forInput.charAt(c) - '0';
                }
            }

            int center = farmLength / 2;
            int idx = 1;
            int cnt = 0;

            for (int r = 0; r < farmLength; r++) {
                if (r == 0 || r == farmLength - 1) {
                    cnt += farm[r][center];
                } else {
                    if (r < center) {
                        for (int i = center - idx; i <= center + idx ; i++) {
                            cnt += farm[r][i];
                        }
                        idx++;
                    } else {
                        for (int i = center - idx; i <= center + idx ; i++) {
                            cnt += farm[r][i];
                        }
                        idx--;
                    }
                }
            }
            System.out.printf("#%d %d%n", t, cnt);
        }
    }
}
