import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] parent;
	static int n, m, operator, a, b;
	
	public static void main(String[] args) throws IOException {
		
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parent = new int[n + 1];
		
		for (int i = 0; i < n + 1; i++) {
			makeSet(i);
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			operator = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if (operator == 0) {
				union(findSet(a), findSet(b));
			} else {
				if (findSet(a) == findSet(b)) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
		}
		
		System.out.println(sb.toString());
		
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
		parent[y] = x;
	}
}
