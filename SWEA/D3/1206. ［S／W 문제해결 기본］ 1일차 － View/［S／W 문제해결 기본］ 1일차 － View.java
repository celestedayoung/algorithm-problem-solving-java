import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {

            int N = sc.nextInt();

            List<Integer> buildings = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                buildings.add(sc.nextInt());
            }

            int cnt = 0;
            for (int b = 2; b < buildings.size() - 2; b++) {

                out: for (int h = buildings.get(b); h >= 0 ; h--) {
                    // left view
                    if (h > buildings.get(b - 1) && h > buildings.get(b - 2)) {
                        // right view
                        if (h > buildings.get(b + 1) && h > buildings.get(b + 2)) {
                            cnt++;
                        } else {
                            break out;
                        }
                    }
                }
            }
            System.out.printf("#%d %d%n", t, cnt);
        }
    }
}
