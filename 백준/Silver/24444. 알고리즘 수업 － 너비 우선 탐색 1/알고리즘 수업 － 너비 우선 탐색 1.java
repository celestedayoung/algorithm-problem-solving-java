import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int vertexNum, edgeNum, startIdx, start, end, order;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    List<Integer> list = new ArrayList<Integer>();

    static Deque<Integer> myQueue = new ArrayDeque<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        vertexNum = Integer.parseInt(st.nextToken());
        edgeNum = Integer.parseInt(st.nextToken());
        startIdx = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= vertexNum; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        visited = new int[vertexNum + 1];
        order = 1;
        bfs(startIdx);

        for (int i= 1; i < visited.length; i++) {
            System.out.println(visited[i]);
        }

    }

    static void bfs(int vertex) {

        visited[vertex] = order;
        myQueue.addLast(vertex);

        while (!myQueue.isEmpty()) {
            int now = myQueue.pollFirst();
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                if (visited[next] == 0) {
                    visited[next] = ++order;
                    myQueue.addLast(next);
                }
            }
        }


    }

}