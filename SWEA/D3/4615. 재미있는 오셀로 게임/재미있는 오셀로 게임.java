import java.util.Scanner;
 
public class Solution {
     
    static Scanner sc;
    static int testNum, N, gameCount;
     
    public static void main(String[] args) {
         
        sc = new Scanner(System.in);
         
        testNum = sc.nextInt();
         
        int[][] arr;
        int y, x, col, ry, rx, w, b;
        int[] dy = {-1, -1, 1, 1, 0, 0, 1, -1};
        int[] dx = {-1, 1, 1, -1, 1, -1, 0, 0};
         
        for (int t = 1; t <= testNum; t++) {
             
            w = 0;
            b = 0;
            N = sc.nextInt();
            gameCount = sc.nextInt();
             
            arr = new int[N][N];
             
            arr[N / 2 - 1][N / 2 - 1] = 2;
            arr[N / 2][N / 2] = 2;
            arr[N / 2 - 1][N / 2] = 1;
            arr[N / 2][N / 2 - 1] = 1;
             
            for (int g = 0; g < gameCount; g++) {
                 
                y = sc.nextInt() - 1;
                x = sc.nextInt() - 1;
                 
                col = sc.nextInt();
                 
                arr[y][x] = col;
                 
                for (int i = 0; i < 8; i++) {
                     
                    ry = y;
                    rx = x;
                     
                    for (int j = 0; j < N; j++) {
                         
                        ry += dy[i];
                        rx += dx[i];
                         
                        if (ry >= 0 && ry < N && rx >= 0 && rx < N) {
                            if (arr[ry][rx] == 0) {
                                break;
                            }
                            if (arr[ry][rx] == arr[y][x]) {
                                for (int z = j; z >= 0; z--) {
                                    ry -= dy[i];
                                    rx -= dx[i];
                                    arr[ry][rx] = col;
                                }
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                 
            }
             
            int black = 0;
            int white = 0;
             
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 1) {
                        black++;
                    } else if (arr[i][j] == 2) {
                        white++;
                    }
                }
            }
            System.out.printf("#%d %d %d%n", t, black, white);
        }
    }
}