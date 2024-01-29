import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                nums.add(sc.nextInt());
            }

            nums.sort(null);

            System.out.printf("#%d %d%n", t, nums.get(9));
        }
    }
}