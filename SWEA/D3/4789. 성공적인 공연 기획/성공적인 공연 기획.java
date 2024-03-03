
import java.util.Scanner;

public class Solution {

    static Scanner sc;
    static int testNum;
    static String input;
    static int[] people;
    static int cnt;
    static int result;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        testNum = sc.nextInt();
        sc.nextLine();

        for (int t = 1; t <= testNum ; t++) {

            input = sc.nextLine();
            people = new int[input.length()];

            for (int i = 0; i < input.length(); i++) {
                people[i] = input.charAt(i) - '0';
            }

            cnt = people[0];
            result = 0;

            for (int i = 1; i < people.length; i++) {

                if (cnt < i) {
                    result += i - cnt;
                    people[i] += i - cnt;
                }
                cnt += people[i];
            }
            System.out.printf("#%d %d%n", t, result);
        }
    }
}
