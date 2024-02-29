import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	
	static Scanner sc;
	static StringTokenizer st;
	static int testNum;
	static int cardNum;
	static Deque<String> cardSet1;
	static Deque<String> cardSet2;
	static List<String> result;
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		testNum = sc.nextInt();
		
		for (int t = 1; t <= testNum; t++) {
			
			cardNum = sc.nextInt();
			sc.nextLine();
			
			st = new StringTokenizer(sc.nextLine());
			
			cardSet1 = new ArrayDeque<String>();
			cardSet2 = new ArrayDeque<String>();
			
			for (int i = 1; i <= cardNum; i++) {
				if (cardNum % 2 != 0) {
					if (i <= (cardNum / 2) + 1) {
						cardSet1.addLast(st.nextToken());
					} else {
						cardSet2.addLast(st.nextToken());
					}					
				} else {
					if (i <= (cardNum / 2)) {
						cardSet1.addLast(st.nextToken());
					} else {
						cardSet2.addLast(st.nextToken());
					}		
				}
			}

			result = new ArrayList<String>();
			
			while (!cardSet1.isEmpty() || !cardSet2.isEmpty()) {
				if (!cardSet1.isEmpty()) {
					result.add(cardSet1.pollFirst());					
				}
				if (!cardSet2.isEmpty()) {
					result.add(cardSet2.pollFirst());					
				}
			}

			System.out.printf("#%d", t);
			for (int i = 0; i < result.size(); i++) {
				System.out.print(" " + result.get(i));
			}
			System.out.println();
		}
		
	}

}
