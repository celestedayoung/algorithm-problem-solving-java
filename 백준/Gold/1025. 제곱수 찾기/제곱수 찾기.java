import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[][] table;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        table = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                table[i][j] = line.charAt(j) - '0';
            }
        }

        int maxDim = Math.max(N, M);
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int di = -maxDim; di <= maxDim; di++) {
                    for (int dj = -maxDim; dj <= maxDim; dj++) {
                        if (di == 0 && dj == 0) continue;
                        
                        if (!isValidDirection(i, j, di, dj)) continue;
                        
                        processSequence(i, j, di, dj);
                    }
                }
            }
        }
        
        System.out.println(answer);
    }

    private static boolean isValidDirection(int startI, int startJ, int di, int dj) {
        if (di == 0 && dj == 0) return false;
        
        return startI >= 0 && startI < N && 
               startJ >= 0 && startJ < M;
    }

    private static void processSequence(int startI, int startJ, int di, int dj) {
        int num = 0;
        int curI = startI;
        int curJ = startJ;
        
        while (curI >= 0 && curI < N && curJ >= 0 && curJ < M) {
            num = num * 10 + table[curI][curJ];
            
            if (num > 1000000000) break;
            
            if (isPerfectSquare(num)) {
                answer = Math.max(answer, num);
            }
            
            curI += di;
            curJ += dj;
        }
    }

    private static boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}