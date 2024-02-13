import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        String[] dataStructure =  br.readLine().split(" ");
        String[] data = br.readLine().split(" ");

        Deque<String> myQueue = new ArrayDeque<>();

        for (int i = 0; i < num; i++) {
            if (dataStructure[i].equals("0")) {
                myQueue.addLast(data[i]);
            }
        }

        int inputLength = Integer.parseInt(br.readLine());
        String[] inputNums = br.readLine().split(" ");
        for (int i = 0; i < inputLength; i++) {
            myQueue.addFirst(inputNums[i]);
            bw.write(myQueue.pollLast() + " ");
        }
        bw.flush();
    }
}
