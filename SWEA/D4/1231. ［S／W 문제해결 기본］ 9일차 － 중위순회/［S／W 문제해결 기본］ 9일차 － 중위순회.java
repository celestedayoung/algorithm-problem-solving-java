import java.util.Arrays;
import java.util.Scanner;

class Node {
	int vertex;
	String letter;
	Node left;
	Node right;
	
	Node(){}
	
	Node(int vertex, String letter) {
		this.vertex = vertex;
		this.letter = letter;
	}

	@Override
	public String toString() {
		return "Node [num=" + vertex + ", letter=" + letter + ", left=" + left + ", right=" + right + "]";
	}
}

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			
			int vertexNum = sc.nextInt();
			sc.nextLine();
			
			Node[] nodes = new Node[vertexNum + 1];
			for (int i = 1; i < nodes.length; i++) {
				nodes[i] = new Node();
			}
			
			for (int i = 1; i < nodes.length; i++) {
				
				String[] inputArr = sc.nextLine().split(" ");

				nodes[i].vertex = Integer.parseInt(inputArr[0]);
				nodes[i].letter = inputArr[1];
				
				for (int j = 2; j < inputArr.length; j++) {
					if (nodes[i].left == null) {
						nodes[i].left = nodes[j];
					}
					if (nodes[i].right == null) {
						nodes[i].right = nodes[inputArr.length - 1];
					}
				}
				
			}
			System.out.printf("#%d ", t);
			inorder(1, nodes);
			System.out.println();
		}		
		
	}
	
	static void inorder(int i, Node[] nodes) {
		// 기저 조건
		if (nodes.length <= i || nodes[i].equals(0)) {
			return;
		}
		
		// 왼쪽 자식 방문
		inorder(i * 2, nodes);
		
		// 부모 노드 방문
		System.out.print(nodes[i].letter);
		
		
		// 오른쪽 자식 방문
		inorder(i * 2 + 1, nodes);
	}
}
