import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, r, c;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(zFunction(N, r, c));
    }

    static int zFunction(int n, int r, int c) {

        if (n == 0) return 0;

        int half = (int)Math.pow(2, n - 1);

        if (r < half && c < half) return zFunction(n - 1, r, c);
        if (r < half && c >= half) return half * half + zFunction(n - 1, r, c - half);
        if (r >= half && c < half) return 2 * half * half + zFunction(n - 1, r - half, c);

        return 3 * half * half + zFunction(n - 1, r - half, c - half);
    }
}
