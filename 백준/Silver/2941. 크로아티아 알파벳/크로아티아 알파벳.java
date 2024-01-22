import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] letters = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String testCase = sc.next();

        int cnt = 0;
        int left = testCase.length();

        for (int l = 0; l < letters.length; l++) {
            int pointer = 0;

            for (int t = 0; t <= testCase.length() - letters[l].length(); t++) {
                String compare = testCase.substring(pointer, pointer + letters[l].length());

                if (letters[l].equals(compare)) {
                    left -= letters[l].length();
                    testCase = testCase.replaceFirst(compare, "x");
                    cnt++;
                }
                pointer++;
            }
        }
        System.out.println(cnt + left);
    }
}