import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] input, result;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        result = new int[M];
        Arrays.sort(input);

        makeNumbers(0);
        System.out.println(sb);
    }

    static void makeNumbers(int k) {
        if (k == M) {
            for (int i = 0; i < M - 1 ; i++) {
                sb.append(result[i] + " ");
            }
            sb.append(result[result.length - 1]).append("\n");
            return;
        }
        for (int i = 0; i < N ; i++) {
            result[k] = input[i];
            makeNumbers(k + 1);
        }
    }
}
