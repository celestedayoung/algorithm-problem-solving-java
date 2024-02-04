package Theory;

import java.util.Arrays;

public class SelectionSort {

    public static int selectionSort(int[] nums, int k) {

        for (int i = 0; i < nums.length - 1; i++) {

            int minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIdx] > nums[j]) {
                    minIdx = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = tmp;
        }
        return nums[k];
    }

    public static void main(String[] args) {
        int[] testCase = {10, 7, 4, 6, 3, 2};
        System.out.println(selectionSort(testCase, 3));
    }
}
