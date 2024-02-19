import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int cakeLength = sc.nextInt();
        int[] cake = new int[cakeLength + 1];

        int peopleNum = sc.nextInt();
        int[] peopleWant = new int[peopleNum];
        int[] peopleEat = new int[peopleNum];

        for(int p = 0; p < peopleNum; p++) {

            int startIdx = sc.nextInt();
            int endIdx = sc.nextInt();
            int cnt = 0;

            peopleWant[p] = endIdx - startIdx;

            for (int i = startIdx; i <= endIdx; i++) {
                peopleWant[p] = endIdx - startIdx;
                if (cake[i] == 0) {
                    cake[i]++;
                    cnt++;
                }
            }
            peopleEat[p] = cnt;
        }

        int maxWant = -1;
        int maxWantIdx = 0;
        for (int i = 0; i < peopleWant.length; i++) {
            if (peopleWant[i] > maxWant) {
                maxWant = peopleWant[i];
                maxWantIdx = i + 1;
            }
        }

        int maxEat = -1;
        int maxEatIdx = 0;
        for (int i = peopleEat.length - 1; i >= 0; i--) {
            if (peopleEat[i] >= maxEat) {
                maxEat = peopleEat[i];
                maxEatIdx = i + 1;
            }
        }
//        System.out.println(Arrays.toString(peopleWant));
//        System.out.println(Arrays.toString(peopleEat));
        System.out.println(maxWantIdx);
        System.out.println(maxEatIdx);
    }
}
