import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int vertexNum, edgeNum, startIdx, order;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        vertexNum = Integer.parseInt(st.nextToken());
        edgeNum = Integer.parseInt(st.nextToken());
        startIdx = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= vertexNum; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        visited = new int[vertexNum + 1];
        order = 1;
        dfs(startIdx);

        for (int i = 1; i < visited.length; i++) {
            System.out.println(visited[i]);
        }
    }

    static void dfs(int vertex) {
        visited[vertex] = order;

        for(int i = 0; i < graph.get(vertex).size(); i++) {
            int newVertex = graph.get(vertex).get(i);
            if(visited[newVertex] == 0){
                order++;
                dfs(newVertex);
            }
        }
    }
}
