import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Person {
    int r, c, length;

    Person() {}

    Person(int r, int c, int length) {
        this.r = r;
        this.c = c;
        this.length = length;
    }
}


public class Main {

    static Scanner sc;
    static int N, M, min;
    static String[] input;
    static int[][] maze;
    static Deque<Person> myQueue;

    static int[] deltaR = {-1, 1, 0, 0};
    static int[] deltaC = {0, 0, -1, 1};

    public static void main(String[] args) {

        sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        maze = new int[N][M];
        for (int r = 0; r < N; r++) {
            input = sc.nextLine().split("");
            for (int c = 0; c < M; c++) {
                maze[r][c] = Integer.parseInt(input[c]);
            }
        }

        myQueue = new ArrayDeque<>();
        myQueue.addLast(new Person(0, 0, 1));

        min = 1;

        escape();

        System.out.println(min);

    }

    public static void escape() {

        while (!myQueue.isEmpty()) {

            Person current = myQueue.pollFirst();

            maze[current.r][current.c] = -1;


            if (current.r == N - 1 && current.c == M - 1) {
                min = current.length;
            }

            int newLength = ++current.length;
            for (int d = 0; d < 4; d++) {

                int newR  = current.r + deltaR[d];
                int newC = current.c + deltaC[d];

                if (rangeCheck(newR, newC) && maze[newR][newC] == 1) {
                    myQueue.addLast(new Person(newR, newC, newLength));
                    maze[newR][newC] = -1;
                }
            }


        }

    }

    public static boolean rangeCheck(int r, int c) {
        if (r >= 0 && r < N && c >= 0 && c < M) return true;
        return false;
    }

}
