import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int peopleNum = sc.nextInt();
        int killNum = sc.nextInt();

        int[] peopleList = new int[peopleNum];
        for (int i = 0; i < peopleNum; i++) {
            peopleList[i] = i + 1;
        }

        int[] josephus  = new int[peopleNum];
        int idx  = -1;

        for (int k = 0; k < peopleNum; k++) {

            int idxCnt = 0;

            while (idxCnt < killNum) {
                if (idx >= peopleNum - 1) {
                    idx -= peopleNum;
                }
                idx++;
                if (peopleList[idx] != 0) {
                    idxCnt++;
                }
            }
            josephus[k] = peopleList[idx];
            peopleList[idx] = 0;
        }

        for (int i = 0; i < peopleList.length; i++) {
            if (josephus.length == 1) {
                System.out.print("<" + josephus[0] + ">");
            } else {
                if (i == peopleList.length - 1) {
                    System.out.print(josephus[i] + ">");
                } else if (i == 0) {
                    System.out.print("<"+ josephus[i] + ", ");
                } else {
                    System.out.print(josephus[i] + ", ");
                }
            }
        }
    }
}

