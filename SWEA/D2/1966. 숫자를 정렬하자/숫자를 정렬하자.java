import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testNum = sc.nextInt();

        for (int t = 1; t <= testNum; t++) {
            int nums = sc.nextInt();
            int[] numsArr = new int[nums];

            for (int i = 0; i < nums; i++) {
                numsArr[i] = sc.nextInt();
            }

            int[] sortedArr = insertionSort(numsArr);

            System.out.printf("#%d", t);
            for (int i = 0; i < sortedArr.length; i++) {
                System.out.printf(" %d", sortedArr[i]);
            }
            System.out.println();
        }
    }

    public static int[] insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > key ;j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}
