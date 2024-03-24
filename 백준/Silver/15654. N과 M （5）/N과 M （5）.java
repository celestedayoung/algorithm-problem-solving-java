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

        makeNumbers(input, 0);
    }

    static void makeNumbers(int[] arr, int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < N ; i++) {
            if (!checked[arr[i]]) {
                result[k] = arr[i];
                checked[arr[i]] = true;
                makeNumbers(arr, k + 1);
                checked[arr[i]] = false;
            }
        }
    }
}
