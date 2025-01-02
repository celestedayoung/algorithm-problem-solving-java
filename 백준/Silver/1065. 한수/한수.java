import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, count;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        count = 0;
        for (int i = 1; i <= N; i++) {
            if(isHansoo(i)) {
                count++;
            }
        }
        System.out.println(count);

    }

    private static boolean isHansoo(int N) {
        if (N < 100) {
            return true;
        }

        int hundreds = N / 100;
        int tens = (N / 10) % 10;
        int ones = N % 10;

        return (hundreds - tens) == (tens - ones);
    }
}
