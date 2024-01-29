import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<Integer> people = new ArrayList<Integer>();
		
		for (int i = 0; i < 9; i++) {
			people.add(sc.nextInt());
		}
		
		int sum = 0;
		int false1 = 0;
		int false2 = 0;
		for (int s = 0; s < people.size(); s++) {
			sum += people.get(s);
		}
		
		for (int i = 0; i < people.size(); i++) {
			int result = 0;
			
			for (int j = 0; j < people.size() - 1; j++) {
				
				if (j != i) {
					result = sum - (people.get(i) + people.get(j));
					if (result == 100) {
						false1 = i;
						false2 = j;
						break;
						}
				}
			}
		}
		people.remove(false1);
		people.remove(false2);
		people.sort(null);
		
		
		int min = 0;
		for (int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i));
		}
	}
}