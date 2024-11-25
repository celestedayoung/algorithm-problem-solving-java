import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer> coins = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coins.add(Integer.parseInt(st.nextToken()));
        }
        Collections.reverse(coins);

        int count = 0;
        for (int coin : coins) {
            if (coin <= K) {
                count += K / coin;
                K %= coin;
            }
        }

        System.out.println(count);
    }
}
