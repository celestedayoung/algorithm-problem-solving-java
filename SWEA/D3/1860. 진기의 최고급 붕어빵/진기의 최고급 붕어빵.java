import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testNum = sc.nextInt();

        for (int t = 1; t <= testNum ; t++) {

            int peopleNum = sc.nextInt();
            int fishTime = sc.nextInt();
            int fishNum = sc.nextInt();

            int[] peopleTime = new int[peopleNum];
            for (int i = 0; i < peopleNum; i++) {
                peopleTime[i] = sc.nextInt();
            }
            peopleTime = countingSort(peopleTime);

            List<Integer> fish  = new ArrayList<>();

            int time = 0;
            int idx = 0;

            while (true) {

                if (time == peopleTime[idx]) {
                    if (fish.size() != 0) {

                        fish.remove(0);
                        idx++;

                    } else {
                        System.out.printf("#%d %s%n", t, "Impossible");
                        break;
                    }
                }

                if (idx > 0  && peopleTime[idx] != peopleTime[idx - 1]) {
                    time++;
                } else if (idx == 0) {
                    time++;
                }

                if (time > 0 && time % fishTime == 0) {
                    for (int i = 0; i < fishNum; i++) {
                        fish.add(1);
                    }
                }

//                if (time == peopleTime[peopleTime.length - 1]) {
//                    System.out.printf("#%d %s%n", t, "Possible");
//                    break;
//                }
                if (idx == peopleTime.length - 1 && fish.size() != 0) {
                    System.out.printf("#%d %s%n", t, "Possible");
                     break;
                }

            }
        }
    }

    public static int[] countingSort(int[] arr) {

        int[] count = new int[11112];
        int[] sortedArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < arr.length; i++) {
            sortedArr[--count[arr[i]]] = arr[i];
        }

        return sortedArr;
    }
}
