import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			int passwordLength = sc.nextInt();
			
			SinglyLinkedList passwords = new SinglyLinkedList();
			
			for (int i = 0; i < passwordLength; i++) {
				passwords.addLast(sc.next());
			}
			
			int orderLength = sc.nextInt();
			
			int orderCnt = 0;
			while(orderCnt < orderLength) {
				
				String inputOrder = sc.next();
				if (inputOrder.equals("I")) {
					
					int insertIdx = sc.nextInt();
					int insertNum = sc.nextInt();
					
					for (int i = 0; i < insertNum; i++) {
						passwords.add(insertIdx, sc.next());
						insertIdx++;
					}
					orderCnt++;
					
				} else if (inputOrder.equals("D")) {
					
					int deleteIdx = sc.nextInt();
					int deleteNum = sc.nextInt();
					
					for (int d = 0; d < deleteNum; d++) {
						passwords.remove(deleteIdx);
//						deleteIdx--;
					}
					orderCnt++;
					
				} else if (inputOrder.equals("A")) {
					
					int addNum = sc.nextInt();
					for (int a = 0; a < addNum; a++) {
						passwords.addLast(sc.next());
					}
					orderCnt++;
				}		
			}
			System.out.printf("#%d", t);
			passwords.printItem(10);;
		}
	}
	
	// Node Class
	static class Node {
		String data;
		Node link;
		
		Node() {}
		Node(String data) {
			this.data = data;
		}
	}
		
	// Singly Linked List Class
	static class SinglyLinkedList {
		
		Node head;
		int size;
		int idx;
		
		SinglyLinkedList() {
			head = new Node();
		}
		
		// [삽입]: 기존의 연결을 끊기 전에 새로 삽입하고자 하는 노드를 먼저 연결시켜야 한다.
		// 가장 앞에 삽입
		void addFirst(String data) {
			Node newNode = new Node(data);
			
			newNode.link = head.link;
			head.link = newNode;
			
			size++;
		}
		
		// 가장 뒤에 삽입
		void addLast(String data) {
			Node newNode = new Node(data);
			
			Node curr = head;
			while(curr.link != null) {
				curr = curr.link;
			}
			
			curr.link = newNode;
			size++;
		}
		
		// 중간에 삽입: 지정한 idx 뒤에 삽입
		// add(0) = addFirst()
		// add(size) = addLast()
		void add(int idx, String data) {
			
			if (idx < 0 || size < idx) {
				System.out.println("삽입할 수 없는 위치입니다.");
				return;
			}
			
			Node curr = head;
			for (int i = 0; i < idx; i++) {
				curr = curr.link;
			}
			
			Node newNode = new Node(data);
			newNode.link = curr.link;
			curr.link = newNode;
			
			size++;
			
		}
		
		// [삭제]: 연결만 끊어주면 더 이상 접근할 수 없는 노드는 GC가 삭제해준다.
		// 특정 idx에 해당하는 노드 삭제
		void remove(int idx) {
			if (idx < 0 || getSize() <= idx) {
				System.out.println("삭제할 수 있는 범위를 벗어났습니다.");
				return;
			}
			Node curr = head;
			
			for (int i = 0; i < idx; i++) {
				curr = curr.link;
			}
			// 반복문이 끝나면 curr는 삭제할 노드 앞의 노드를 가리킨다.
			curr.link = curr.link.link;
			
			size--;
		}
		
		// [조회]
		// 모든 데이터 조회
		void printList() {
			Node curr = head.link;
			while (curr != null) {
				System.out.print(" " + curr.data);
				curr = curr.link;
			}
			System.out.println();
		}
		
		// 처음부터 특정 idx까지 데이터 조회
		void printItem(int idx) {
			Node curr = head.link;
			for (int i = 0; i < idx; i++) {
				System.out.print(" "+ curr.data);
				curr = curr.link;
			}
			System.out.println();
			
		}
		
		int getSize() {
			Node curr = head;
			int size = 0;
			while (curr.link != null) {
				curr = curr.link;
				size++;
			}
			return size;
		}
	}
}