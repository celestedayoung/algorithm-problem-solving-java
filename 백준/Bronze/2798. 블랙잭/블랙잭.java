import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] cardSet;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        cardSet = new int[N];
        for (int i = 0; i < cardSet.length; i++) {
            cardSet[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> diffList = new ArrayList<>();
        List<Integer> cardSetList = new ArrayList<>();
        for (int i = 0; i < cardSet.length - 2; i++) {
            int sum = 0;
            for (int j = i + 1; j < cardSet.length - 1; j++) {
                for (int k = j + 1; k < cardSet.length; k++) {
                    sum = cardSet[i] + cardSet[j] + cardSet[k];
                    if ( M - sum >= 0) {
                        diffList.add(M - sum);
                        cardSetList.add(sum);
                    }

                }
            }
        }

        int minIndex = diffList.indexOf(Collections.min(diffList));
        System.out.println(cardSetList.get(minIndex));





    }

}
