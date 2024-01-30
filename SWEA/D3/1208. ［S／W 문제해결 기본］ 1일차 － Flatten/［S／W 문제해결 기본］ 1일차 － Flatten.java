import java.util.Arrays;
import java.util.Scanner;

public class Solution {
//	CountingSort 메소드
	public static int[] countingSort(int[] a) {
			
			//  최댓값 찾기
			int max = -9876;
			for (int i = 0; i < a.length; i++) {
				if (max < a[i]) {
					max = a[i];
				}
			}
			
			// counting
			int[] cnt = new int[max + 1];
			for (int i = 0; i < a.length; i++) {
				cnt[a[i]]++;
			}
			
			// cnt를 누적합으로 만들기
			for (int i = 1; i < cnt.length; i++) {
				cnt[i] += cnt[i - 1];
			}
			
			// 배열 a를 역방향으로 순회하면서 누적합 배열과 연결지어 위치를 찾아준다. 
			int[] answer = new int[a.length];
			for (int i = a.length - 1; i >= 0; i--) {
				answer[--cnt[a[i]]] = a[i];
			}
			return answer;
		}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			
			int dump = sc.nextInt();
			
			int[] boxes = new int[100];
			
			for (int i = 0; i < 100; i++) {
				boxes[i] = sc.nextInt();
			}
			
//			boxes를 오름차순으로 정렬하기
			boxes = countingSort(boxes);



			// 평탄화 진행
			while (dump > 0) {
				
				boxes[0] += 1;
				boxes[99] -= 1;
				
				boxes = countingSort(boxes);
				
				dump--;
			}
			
			int answer = boxes[99] - boxes[0];
			
			System.out.printf("#%d %d%n", t, answer);

		}
	}
}
