import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        char[] message = input.toCharArray();
        int messageLength = message.length;

        int R = 0;
        int C = 0;

        for (int i = 1; i < messageLength; i++) {
            if (messageLength % i == 0) {
                if (i <= messageLength / i) {
                    R = i;
                    C = messageLength / i;
                }
            }
        }

        char[][] matrix = new char[R][C];

        int idx = 0;
        for (int c = 0; c < C; c++) {
            for (int r = 0; r < R; r++) {
                matrix[r][c] = message[idx];
                idx++;
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                System.out.print(matrix[r][c]);
            }
        }
    }
}
