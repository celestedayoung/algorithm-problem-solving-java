import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Pair pairs[];

    private static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        pairs = new Pair[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Pair pair = new Pair(y, x);

            pairs[i] = pair;
        }

        double result = solution();

        System.out.println(result);

        br.close();
    }

    private static double solution() {
        double result = 0;

        for (int first = 0; first < N - 2; first++) {
            for (int second = first + 1; second < N - 1; second++) {
                for (int third = second + 1; third < N; third++) {
                    double tmpWidth = calcTriangle(pairs[first], pairs[second], pairs[third]);
                    result = Math.max(result, tmpWidth);
                }
            }
        }

        return result;
    }

    private static double calcTriangle(Pair a, Pair b, Pair c) {
        double result = 0d;

        double first = a.x * b.y + b.x * c.y + c.x * a.y;
        double second = b.x * a.y + c.x * b.y + a.x * c.y;

        result = 0.5 * Math.abs(first - second);

        return result;
    }
}