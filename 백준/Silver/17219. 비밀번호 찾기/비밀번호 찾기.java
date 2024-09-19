import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static String address, key, problem;
    static HashMap<String, String> password;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        password = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            address = st.nextToken();
            key = st.nextToken();
            password.put(address, key);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            problem = st.nextToken();
            if (password.containsKey(problem)) {
                System.out.println(password.get(problem));
            }
        }
    }
}
