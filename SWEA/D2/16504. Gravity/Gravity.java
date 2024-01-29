import java.util.Scanner;

public class  Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int rowLength = sc.nextInt();
            int[] blocks = new int[rowLength];

            for (int i = 0; i < blocks.length; i++) {
                blocks[i] = sc.nextInt();
            }

            int max = 0;
            for (int i = 0; i < blocks.length; i++) {
                if (blocks[i] > max) {
                    max = blocks[i];
                }
            }

            int[] diffList = new int[max];
            for (int i = 0; i < max; i++) {
                int[] forDiffCal = new int[rowLength];

                for (int j = 0; j < rowLength; j++) {
                    if (blocks[j] > i) {
                        forDiffCal[j] = 1;
                    } else {
                        forDiffCal[j] = 0;
                    }
                }

                int stardIdx = 0;
                out: for (int j = 0; j < forDiffCal.length; j++) {
                    if (forDiffCal[j] == 1) {
                        stardIdx = j;
                        break out;
                    }
                }
                
                int diff = 0;
                for (int k = stardIdx; k < rowLength; k++) {
                    if (forDiffCal[k] == 0) {
                        diff += 1;
                    }
                }
                diffList[i] = diff;
            }

            int result = 0;
            for (int i = 0; i < diffList.length; i++) {
                if (result < diffList[i]) {
                    result = diffList[i];
                }
            }
            System.out.printf("#%d %d%n", t, result);
        }
    }
}
