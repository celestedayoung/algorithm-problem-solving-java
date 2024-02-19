import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);
        
        int cardNum = sc.nextInt();
        int sumNum = sc.nextInt();

        int[] cards = new int[cardNum];
        for (int i = 0; i < cardNum; i++) {
            cards[i] = sc.nextInt();
        }

        List<Integer> cases = new ArrayList<>();
        for (int i = 0; i < cardNum - 2; i++) {
            for (int j = i + 1; j < cardNum - 1; j++) {
                for (int k = j + 1; k < cardNum; k++) {
                    cases.add(cards[i] + cards[j] + cards[k]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < cases.size(); i++) {
            if (min > Math.abs(sumNum - cases.get(i)) && cases.get(i) <= sumNum) {
                min = Math.abs(sumNum - cases.get(i));
                result = cases.get(i);
            }
        }

        System.out.println(result);
    }
}
