import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testNum = sc.nextInt();

        for (int t = 1; t <= testNum; t++) {

            String bar = sc.next();
            char[] barArr = bar.toCharArray();

            for (int i = 0; i < bar.length() - 1; i++) {
                if (barArr[i] == '(' && barArr[i + 1] == ')') {
                    barArr[i] = 'x';
                    barArr[i + 1] = 'x';
                }
            }
            int startIdx = 0;
            for (int i = 0; i < barArr.length; i++) {
                if (barArr[i] == '(') {
                    startIdx = i;
                    break;
                }
            }
            Stack myStack = new Stack();
            int laserCnt = 0;
            int barCnt = 0;
            int underBar = 0;

            for (int i = startIdx; i < barArr.length; i++) {
                if (barArr[i] != ')') {
                    if (barArr[i] == '(') {
                        underBar++;
                    }
                    myStack.push(barArr[i]);
                } else  {
                    while (myStack.peak() != '(') {
                        if (myStack.pop() == 'x') {
                            laserCnt++;
                        }
                    }
                    barCnt += underBar* ((laserCnt/2) + 1);
                    myStack.pop();
                    barCnt -= underBar - 1;
                    underBar--;
                    laserCnt = 0;
                    if (myStack.isEmpty()) {
                        underBar = 0;
                    }
                }
            }
            System.out.printf("#%d %d%n", t, barCnt);
        }
    }

    public static class Stack {

        private static List<Character> stackArr = new ArrayList<>();
        private static int top = -1;

        public Stack() {
            this.top = -1;
            this.stackArr = new ArrayList<>();
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == stackArr.size() - 1;
        }

        public char pop() {

            if (isEmpty()) {
                return '?';
            }
            char tmp = stackArr.get(top);
            stackArr.remove(top--);
            return tmp;
        }

        public void push (char item) {
            ++top;
            stackArr.add(item);
        }

        public int peak() {
            return stackArr.get(top);
        }

    }

}
