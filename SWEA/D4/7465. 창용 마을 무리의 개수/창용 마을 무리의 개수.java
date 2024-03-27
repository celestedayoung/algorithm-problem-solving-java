import java.util.Arrays;
import java.util.Scanner;

class Edge {
	int start, end;
	
	public Edge(int start, int end) {
		this.start = start;
		this.end = end;
	}
		
}

public class Solution {
	
	static Scanner sc;
	static int[] parent;
	static int testNum, N, M, group;
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		testNum = sc.nextInt();
		
		for (int t = 1; t <= testNum; t++) {
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			parent = new int[N + 1];
			Edge[] edges = new Edge[M];
			
			for (int i = 0; i < M; i++) {
				edges[i] = new Edge(sc.nextInt(), sc.nextInt());
			}
			
			for (int i = 1; i <= N; i++) {
				makeSet(i);
			}
			
			group = N;
			
			for (int i = 0; i < M; i++) {
				int px = findSet(edges[i].start);
				int py = findSet(edges[i].end);
				union(px, py);
			}
			
			System.out.printf("#%s %d%n", t, group);

		}
	}
	
	static void makeSet(int x) {
		parent[x] = x;
	}
	
	static int findSet(int x) {
		if (parent[x] != x) {
			parent[x] = findSet(parent[x]);
		}
		return parent[x];
	}
	
	static void union(int x, int y) {
		if (x != y) {
			group--;
		}
		parent[y] = x;
	}
}
