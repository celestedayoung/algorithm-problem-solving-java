import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);

        char open1 ='(';
        char open2 = '{';
        char open3 = '[';
        char open4= '<';

        char close1 = ')';
        char close2 = '}';
        char close3 = ']';
        char close4 = '>';

        

        for (int t = 1; t <= 10; t++) {
        	
        	int testCaseLength = sc.nextInt();
        	
            String text = sc.next();
            char[] textArr = text.toCharArray();
        	
            int flag = 1;
            Stack.stack = new char[10000];
            Stack.top = -1;
            
        	for (int i = 0; i < testCaseLength; i++) {
                if (textArr[i] == open1 || textArr[i] == open2 || textArr[i] == open3 || textArr[i] == open4) {
                    Stack.push(textArr[i]);
                    
                } else {
                    if (textArr[i] == close1) {
                    	
                        if (Stack.pop() != open1) {
                            flag = 0;
                            break;
                        }
                    } else if (textArr[i] == close2) {

                        if (Stack.pop() != open2) {
                            flag = 0;
                            break;
                        }
                    } else if (textArr[i] == close3){

                        if (Stack.pop() != open3) {
                            flag = 0;
                            break;
                        }
                    } else if (textArr[i] == close4){

                        if (Stack.pop() != open4) {
                            flag = 0;
                            break;
                        }
                    }
                }
            }
            System.out.printf("#%d %d%n", t, flag);
        }
    }

    public static class Stack {
        static char[] stack = new char[10000];
        static int top = -1;

        public static boolean isEmpty() {
            return top == -1;
        }

        public static boolean isFull() {
            return top == stack.length - 1;
        }

        public static void push(char item) {
            if (isFull()) {
                return;
            }
            stack[++top] = item;
        }

        public static char pop() {
            if (isEmpty()) {
                return 'e';
            }
            return stack[top--];
        }
    }
}
