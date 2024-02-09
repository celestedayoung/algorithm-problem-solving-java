import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testNum = sc.nextInt();

        for (int t = 1; t <= testNum; t++) {

            int cardSet1 = sc.nextInt();
            int cardSet2 = sc.nextInt();

            MyQueue myQueue = new MyQueue();
            List<Integer> cardSum = new ArrayList<>();

            for (int i = 2; i <= cardSet1 + cardSet2; i++) {
                if (i <= cardSet2+1) {
                    myQueue.enQueue(i);
                } else {
                    cardSum.add(i);
                }
            }

            int[] cntArr = new int[cardSet1 + cardSet2 + 1];

            while (cardSum.size() != 0) {

                for (int i = 0; i < MyQueue.queueArr.size(); i++) {
                    cntArr[MyQueue.queueArr.get(i)]++;
                }

                myQueue.deQueue();
                myQueue.enQueue(cardSum.get(0));
                cardSum.remove(0);

            }
            for (int i = 0; i < MyQueue.queueArr.size(); i++) {
                cntArr[MyQueue.queueArr.get(i)]++;
            }
            int max = -1;
            List<Integer> maxList = new ArrayList<>();
            for (int i = 0; i < cntArr.length; i++) {
                if (max < cntArr[i]) {
                    max = cntArr[i];
                }
            }

            for (int i = 0; i < cntArr.length; i++) {
                if (max == cntArr[i]) {
                    maxList.add(i);
                }
            }
            System.out.printf("#%d ", t);
            for (int i = 0; i < maxList.size(); i++) {
                if (i == maxList.size() - 1) {
                    System.out.printf("%d%n", maxList.get(i));
                } else {
                    System.out.printf("%d ", maxList.get(i));
                }
            }

        }
    }

    public static class MyQueue {

        static List<Integer> queueArr= new ArrayList<>();
        private int front = -1;
        private int rear = -1;

        MyQueue() {
            this.queueArr = new ArrayList<>();
            this.front = -1;
            this.rear = -1;
        }

        // 포화 상태 확인
        public boolean isFull() {
            return rear == queueArr.size() - 1;
        }

        // 공백 상태 확인
        public boolean isEmpty()	{
            return queueArr.size() == 0;
        }

        // rear에 원소 삽입
        public void enQueue(int data) {
            ++rear;
            queueArr.add(data);
        }

        // front의 원소 삭제
        public int deQueue() {
            if (isEmpty()) {
                System.out.println(">>> Queue is empty.");
                return -999;
            }
            int tmp = queueArr.get(0);
            queueArr.remove(0);
            return tmp;
        }

        // 삭제될 데이터를 확인
        public int Qpeek() {
            if (isEmpty()) {
                System.out.println(">>> Queue is empty.");
                // Queue에 들어갈 수 없는 범위의 숫자를 return
                return -1;
            }
            return queueArr.get(0);
        }
    }
}