import java.util.Scanner;

public class Solution {

    static Scanner sc;
    static int testNum;
    static int N;
    static String input;
    static int[] cnt;
    static int idx;

    public static void main(String[] args) {

        sc = new Scanner(System.in);

        testNum = sc.nextInt();

        for (int t = 1; t <= testNum; t++) {

            N = sc.nextInt();
            sc.nextLine();

            cnt = new int[27];
            for (int i = 0; i < N; i++) {
                input = sc.next();
                cnt[input.charAt(0) - 65]++;
            }

            idx = 0;
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] == 0) {
                    idx = i;
                    break;
                }
            }
            System.out.printf("#%d %d%n", t, idx);
        }
    }
}
