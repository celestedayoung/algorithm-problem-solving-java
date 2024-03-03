import java.util.Scanner;

public class Solution {

    static Scanner sc;
    static int testNum;
    static int commandNum;
    static int distance;
    static int velocity;
    static int command;
    static int plus;
    static int minus;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        testNum = sc.nextInt();

        for (int t = 1; t <= testNum ; t++) {

            commandNum = sc.nextInt();

            distance = 0;
            velocity = 0;

            for (int c = 0; c < commandNum; c++) {
                command = sc.nextInt();
                if (command == 0) {
                    distance += velocity;
                } else if (command == 1) {
                    plus = sc.nextInt();
                    velocity += plus;
                    distance += velocity;
                } else if (command == 2) {
                    minus = sc.nextInt();
                    if (velocity < minus) {
                        velocity = 0;
                        distance += velocity;
                    } else {
                        velocity -= minus;
                        distance += velocity;
                    }
                }
            }
            System.out.printf("#%d %d%n", t, distance);
        }
    }
}
