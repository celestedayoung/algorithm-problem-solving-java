import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(A);
        int x = Integer.parseInt(br.readLine());
        int start = 0;
        int end = n - 1;
        long count = 0;
        while (start < end){
            if (A[start] + A[end] == x) count++;
            if (A[start] + A[end] <= x) start++;
            else end--;
        }
        System.out.println(count);
    }
}