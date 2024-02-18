import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] score = new int[10];
        int[] diff = new int[10];
        int sum = 0;

        for (int t = 0; t < 10; t++) {
            int mushroom = sc.nextInt();
            sum += mushroom;
            score[t] = sum;
            diff[t] = 100 - sum;
        }

        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = 0; i < 10; i++) {
            if (Math.abs(diff[i]) <= min) {
                min = diff[i];
                minIdx = i;
            }
        }
        System.out.println(score[minIdx]);

    }
}
