
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    static Scanner sc;
    static StringTokenizer st;
    static int testNum;
    static String[] words;
    static String noHole;
    static String oneHole;
    static String twoHoles;
    static String word1;
    static String word2;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        testNum = sc.nextInt();
        sc.nextLine();

        for (int t = 1; t <= testNum ; t++) {

            st = new StringTokenizer(sc.nextLine());
            words = new String[2];

            for (int i = 0; i < 2; i++) {
                words[i] = st.nextToken();
            }

            noHole = "CEFGHIJKLMNSTUVWXYZ";
            oneHole = "ADOPQR";
            twoHoles = "B";

            word1 = "";
            word2 = "";

            if (words[0].length() == words[1].length()) {

                for (int i = 0; i < words[0].length(); i++) {
                    for (int j = 0; j < noHole.length(); j++) {
                        if (words[0].charAt(i) == noHole.charAt(j)) {
                            word1 += "noHole";
                        }
                        if (words[1].charAt(i) == noHole.charAt(j)) {
                            word2 += "noHole";
                        }
                    }
                    for (int j = 0; j < oneHole.length(); j++) {
                        if (words[0].charAt(i) == oneHole.charAt(j)) {
                            word1 += "oneHole";
                        }
                        if (words[1].charAt(i) == oneHole.charAt(j)) {
                            word2 += "oneHole";
                        }
                    }

                    for (int j = 0; j < twoHoles.length(); j++) {
                        if (words[0].charAt(i) == twoHoles.charAt(j)) {
                            word1 += "twoHoles";
                        }
                        if (words[1].charAt(i) == twoHoles.charAt(j)) {
                            word2 += "twoHoles";
                        }
                    }

                }
            } else {
                System.out.printf("#%d %s%n", t, "DIFF");
            }

            if (word1.equals(word2) && words[0].length() == words[1].length()) {
                System.out.printf("#%d %s%n", t, "SAME");
            } else if (!word1.equals(word2)){
                System.out.printf("#%d %s%n", t, "DIFF");
            }

        }
    }
}
