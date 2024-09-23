import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static Set<String> haventSeen, haventHeard;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        haventSeen = new TreeSet<>();
        haventHeard = new TreeSet<>();

        for (int i = 0 ; i < N; i++) {
            haventSeen.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            haventHeard.add(br.readLine());
        }

        haventSeen.retainAll(haventHeard);

        System.out.println(haventSeen.size());
        for (String name: haventSeen) {
            System.out.println(name);
        }

    }
}
