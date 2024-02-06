import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			
			int length = sc.nextInt();
			String testCase = sc.next();
			
			CharStack charStack = new CharStack(10000);
			
			String postfix ="";
			
			// 1. 후위표기법으로 변환
			for (int i = 0; i < length; i++) {
				
				// token 하나씩 가져오기
				char token = testCase.charAt(i);
				
				// 피연산자일 경우: 항상 출력
				if (token >= '0' && token <= '9') {
					postfix += token;
					
				// 연산자일 경우
				// - 여는 괄호: push
				// - 사칙연산자: top에 위치한 연산자의 우선순위가 본인보다 낮을때까지 pop & 출력 -> 본인 push
				// - 닫는 괄호: 여는 괄호 만날 때까지 pop & 출력
				} else {
					if (token == '(') {
						charStack.push(token);
						
					} else if (token == ')') {
						while (!charStack.isEmpty() && charStack.peak() != '(') {
							postfix += charStack.pop();
						}
						charStack.pop();
						
					} else {
						
						if (charStack.isEmpty()) {
							charStack.push(token);
							
						} else {
							if (token == '*') {
								while (!charStack.isEmpty() && charStack.peak() != '(' && charStack.peak() != '+') {
									postfix += charStack.pop();
								}
								charStack.push(token);
							} else if (token == '+') {
								while (!charStack.isEmpty() && charStack.peak() != '(') {
									postfix += charStack.pop();
								}
								charStack.push(token);
							}	
						}
					}
				}
			}
			
			// 2. 계산
			IntStack intStack = new IntStack(10000);

			for (int i = 0; i < postfix.length(); i++) {
				char token = postfix.charAt(i);
				if (token >= '0' && token <= '9') {
					intStack.push(token - '0');
				} else {
					if (token == '+') {

						int last = intStack.pop();
						int first = intStack.pop();

						int result = first + last;
						intStack.push(result);


					} else if (token == '*') {
						int last = intStack.pop();
						int first = intStack.pop();

						int result = first * last;
						intStack.push(result);
					}
				}
			}
			System.out.printf("#%d %d%n", t, intStack.pop());
			}
		}
	
	public static class CharStack {
		
		public static char[] arr = new char[100];
		public static int top = -1;
		
		public CharStack() {}
		
		public CharStack(int size) {
			this.top = -1;
			this.arr = new char[size];
		}
		
		public static boolean isEmpty() {
			return top == -1;
		}
		
		public static boolean isFull() {
			return top == arr.length - 1;
		}
		
		public char pop() {
			
			if (isEmpty()) {
				return '$';
			}
			return arr[top--];
		}
		
		public void push(char item) {
			
			if (isFull()) {
				return;
			}
			arr[++top] = item;
		}
		
		public char peak() {
			return arr[top];
		}
		
	}
	
	public static class IntStack {
		
		public static int[] arr = new int[100];
		public static int top = -1;
		
		public IntStack() {}
		
		public IntStack(int size) {
			this.top = -1;
			this.arr = new int[size];
		}
		
		public static boolean isEmpty() {
			return top == -1;
		}
		
		public static boolean isFull() {
			return top == arr.length - 1;
		}
		
		public int pop() {
			
			if (isEmpty()) {
				return '$';
			}
			int tmp = arr[top];
			arr[top--] = 0;
			return tmp;
		}
		
		public void push(int item) {
			
			if (isFull()) {
				return;
			}
			arr[++top] = item;
		}
		
		public int peak() {
			return arr[top];
		}
	}
}
