import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	
	static Scanner sc;
	static StringTokenizer st;
	static StringBuilder sb;
	static int V, E, start, end;
	static int[][] graph;
	static int[] degree;
	static Deque<Integer> myQueue;
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			
			sb = new StringBuilder();
			sb.append("#" + t + " ");
			
			st = new StringTokenizer(sc.nextLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			graph = new int[V + 1][V + 1];
			degree = new int[V + 1];
			
			st = new StringTokenizer(sc.nextLine());
			for (int i = 0; i < E; i++) {
				start = Integer.parseInt(st.nextToken());
				end = Integer.parseInt(st.nextToken());
				
				graph[start][end] = 1;
				degree[end]++;
			}
			
			myQueue = new ArrayDeque<>();
			for (int i = 1; i <= V; i++) {
				if (degree[i] == 0) {
					myQueue.add(i);
				}
			}
			
			while (!myQueue.isEmpty()) {
				
				int current = myQueue.pollFirst();
				sb.append(current + " ");
				
				for (int i = 0; i <= V; i++) {

					if (graph[current][i] == 1) {
						degree[i]--;
						
						if (degree[i] == 0) {
							myQueue.add(i);
						}
					}
				}
				
			}
			
			System.out.println(sb);
			
		}
	}
}
