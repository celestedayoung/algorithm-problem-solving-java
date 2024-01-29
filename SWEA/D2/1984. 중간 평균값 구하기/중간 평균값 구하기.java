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
            nums.remove(0);
            nums.remove(8);

            int sum = 0;
            for (int i = 0; i < nums.size(); i++) {
                sum += nums.get(i);
            }

            double avg = (double) sum / nums.size();
            System.out.printf("#%d %.0f%n", t, avg);
        }
    }
}
