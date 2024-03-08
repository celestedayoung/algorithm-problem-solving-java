import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int vertexNum, edgeNum, startIdx, start, end;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); 
	static int[] visited;
	static int order;
	
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
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(end);
			graph.get(end).add(start);
			
		}
		
		for (int i = 0; i < graph.size(); i++) {
			Collections.sort(graph.get(i), Collections.reverseOrder());
		}
		
		order = 1;
		visited = new int[vertexNum + 1];
		dfs(startIdx);
		
		for (int i = 1; i < visited.length; i++) {
			System.out.println(visited[i]);
		}
	}
	
	static void dfs(int vertex) {
		visited[vertex] = order;
		
		for (int i = 0; i < graph.get(vertex).size(); i++) {
			int next = graph.get(vertex).get(i);
			if (visited[next] == 0) {
				order++;
				dfs(next);
			}
		}
	}
}
