import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {

            int moneyNum = sc.nextInt();
            int sum = 0;
            int delete = 0;
            Stack.top = -1;
            Stack.stack = new int[100001];

            for (int m = 0; m < moneyNum; m++) {
                int money = sc.nextInt();

                if (money != 0) {
                    Stack.push(money);
                    sum += money;
                } else {
                    delete += Stack.pop();
                }
            }
            int answer = sum - delete;
            System.out.printf("#%d %d%n", t, answer);
        }
    }

    public static class Stack {

        static int[] stack = new int[100002];
        static int top = -1;

        public static void push(int item) {
            if (isFull()) {
                return;
            }
            stack[++top] = item;
        }

        public static int pop() {
            if (isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return stack[top--];
        }

        public static boolean isEmpty() {
            return top == -1;
        }

        public static boolean isFull() {
            return top == stack.length - 1;
        }
    }
}
