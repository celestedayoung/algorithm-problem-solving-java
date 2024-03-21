import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] result;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[10];
        checked = new boolean[10];

        makeNumbers(0);
    }

    static void makeNumbers(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
        for (int i = 1; i <= N ; i++) {
            if (!checked[i]) {
                result[k] = i;
                checked[i] = true;
                makeNumbers(k + 1);
                checked[i] = false;
            }
        }
    }
}