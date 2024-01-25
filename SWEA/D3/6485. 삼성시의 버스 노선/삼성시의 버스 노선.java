import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();


        for (int t = 1; t <= testNum; t++) {

            int N = sc.nextInt();

            int[] busCnt = new int[5001];

            for (int i = 0; i < N; i++) {
                int A = sc.nextInt();
                int B = sc.nextInt();

                for (int j = A; j <= B ; j++) {
                    busCnt[j] += 1;
                }
            }

            int P = sc.nextInt();

            int[] cj = new int[P];
            for (int p = 0; p < P; p++) {
                cj[p] = sc.nextInt();
            }

            System.out.printf("#%d", t);
            for (int i = 0; i < P; i++) {
                System.out.printf(" %d", busCnt[cj[i]]);
            }
            System.out.println();
        }
    }
}