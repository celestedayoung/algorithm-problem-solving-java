import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int studentNum = sc.nextInt();

        IntStack place1 = new IntStack(studentNum);
        IntStack place2 = new IntStack(studentNum);

        int[] tmpArr = new int[studentNum];

        for (int i = 0; i < studentNum; i++) {
            tmpArr[i] = sc.nextInt();
        }

        for (int i = tmpArr.length - 1; i >= 0; i--) {
            place1.push(tmpArr[i]);
        }
        boolean flag = true;
        while (place1.peak() != 1) {
 
            if (place2.isEmpty()) {
                place2.push(place1.pop());
            } else if (place2.peak() > place1.peak()) {
                place2.push(place1.pop());
            } else {
                System.out.println("Sad");
                flag = false;
                break;
            }
        }
        place1.pop();

        int nums = 2;
        if (flag) {
            while (true) {

                if (!place1.isEmpty() && place1.peak() == nums) {
                    place1.pop();
                    nums++;
                } else if (!place2.isEmpty() && place2.peak() == nums) {
                    place2.pop();
                    nums++;
                } else {
                    if (place2.isEmpty()){
                        place2.push(place1.pop());
                    } else if(place1.peak() < place2.peak()) {
                        place2.push(place1.pop());
                    } else {
                        System.out.println("Sad");
                        break;
                    }
                }

                if (place1.isEmpty() && place2.isEmpty()) {
                    System.out.println("Nice");
                    break;
                }

            }
        }


    }

    public static class IntStack {

        public int[] arr = new int[100];
        public int top = -1;

        public IntStack() {}

        public IntStack(int size) {
            this.top = -1;
            this.arr = new int[size];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
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
