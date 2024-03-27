import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * n: 집합의 개수
 * m: 연산의 개수
 * 0 a b: 합집합(a가 포함된 집합과 b가 포함된 집합을 합친다.) -> union
 * 1 a b: 확인(a와 b가 같은 집합에 포함되어 있는지 확인.) -> findSet
 * 
 * 1로 시작하는 연산에 대해 같은 집합에 속해있다면 1을, 아니라면 0을 출력
 * 
 * */

public class Solution {
	
	static Scanner sc;
	static StringBuilder sb;
	static int testNum, n, m, operateNum, a, b;
	static int[] parent;
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		testNum = sc.nextInt();
		
		for (int t = 1; t <= testNum; t++) {
			
			sb = new StringBuilder();
			
			n = sc.nextInt();
			m = sc.nextInt();
			
			parent = new int[n + 1];
			
			for (int i = 1; i <= n; i++) {
				makeSet(i);
			}
			
			for (int i = 0; i < m; i++) {
				
				operateNum = sc.nextInt();
				a = sc.nextInt();
				b = sc.nextInt();
				
				if (operateNum == 0) {
					union(findSet(a), findSet(b));
				} else if (operateNum == 1) {
					if (findSet(a) == findSet(b)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			
			System.out.printf("#%d %s%n", t, sb.toString());
			
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
		parent[y] = x;
	}

}