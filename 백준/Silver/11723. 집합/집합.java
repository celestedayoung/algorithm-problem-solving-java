import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> mySet = new ArrayList<>();
    static StringTokenizer st;
    static int N, number;
    static String method;
    static StringBuilder sb = new StringBuilder(); 
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            method = st.nextToken();
            if (st.hasMoreTokens()) number = Integer.parseInt(st.nextToken());

            switch (method) {
                case "add":
                    add(number);
                    break;
                case "remove":
                    remove(number);
                    break;
                case "check":
                    int res = check(number);
                    sb.append(res).append("\n"); 
                    break;
                case "toggle":
                    toggle(number);
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
            }
        }

        System.out.print(sb.toString());
    }

    static void add(int x) {
        if (mySet.contains(x)) return;
        mySet.add(x);
    }

    static void remove(int x) {
        if (mySet.contains(x)) mySet.remove(mySet.indexOf(x));
    }

    static int check(int x) {
        if (mySet.contains(x)) return 1;
        else return 0;
    }

    static void toggle(int x) {
        if (mySet.contains(x)) mySet.remove(mySet.indexOf(x));
        else mySet.add(x);
    }

    static void all() {
        mySet.clear();
        for (int i = 1; i <= 20; i++) {
            mySet.add(i);
        }
    }

    static void empty() {
        mySet.clear();
    }
}
