import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Star implements Comparable<Star> {
    double x, y, weight;

    Star () {}

    Star(double x, double y, double weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }

    @Override
    public int compareTo(Star star) {
        return Double.compare(this.weight, star.weight);
    }

}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] parent;
    static Star[] tmp;
    static List<Star> stars;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        parent = new int[N];
        tmp = new Star[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            tmp[i] = new Star(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), 0);
        }

        stars = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1 ; j < N; j++) {
                double weight = Math.sqrt(Math.pow((tmp[i].x - tmp[j].x), 2) + Math.pow((tmp[i].y - tmp[j].y), 2));
                stars.add(new Star(i, j, weight));
            }
        }

        Collections.sort(stars);

        for (int i = 0; i < N; i++) {
            makeSet(i);
        }

        double result = 0;
        int pick = 0;

        for (int i = 0; i < stars.size(); i++) {

            int parent1 = (int) findSet((int) stars.get(i).x);
            int parent2 = (int) findSet((int) stars.get(i).y);

            if (parent1 != parent2) {
                union(parent1, parent2);
                result += stars.get(i).weight;
                pick++;
            }

            if (pick == N - 1) {
                break;
            }

        }

        System.out.printf("%.2f%n", result);
    }

    public static void makeSet(int x) {
        parent[x] = x;
    }

    public static int findSet(int x) {
        if (parent[x] != x) {
            parent[x] = findSet(parent[x]);
        }
        return parent[x];
    }

    public static void union(int x, int y) {
        parent[y] = x;
    }
}
