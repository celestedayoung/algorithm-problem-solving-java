import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] input, result;
    static boolean[] checked;

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
        checked = new boolean[100001];
        Arrays.sort(input);

        makeNumbers(input, 0, 0);
    }

    static void makeNumbers(int[] arr, int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < N ; i++) {
            if (!checked[i]) {
                result[depth] = arr[i];
                checked[i] = true;
                makeNumbers(arr, i + 1, depth + 1);
                checked[i] = false;
            }
        }
    }
}
