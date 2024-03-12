import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int row, col;
	static int[][] box;
	static Deque<int[]> myQueue = new ArrayDeque<>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		box = new int[row][col];
		
		for (int r = 0; r < row; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < col; c++) {
				box[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (box[r][c] == 1) {
					myQueue.addLast(new int[] {r, c});
				}
			}
		}
		
		System.out.println(sooksung());

	}
	
	static boolean isSooksung() {
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (box[r][c] == 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	static int sooksung() {
		
		while (!myQueue.isEmpty()) {			
			
			int[] now = (int[]) myQueue.pollFirst();
			int nowR = now[0];
			int nowC = now[1];
			
			for (int d = 0; d < 4; d++) {
				
				int nextR = now[0] + dr[d];
				int nextC = now[1] + dc[d];
				
				if (nextR >= 0 && nextR < row && nextC >= 0 & nextC < col && box[nextR][nextC] == 0) {
					box[nextR][nextC] = box[nowR][nowC] + 1;
					myQueue.addLast(new int[]{nextR, nextC});
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		if (isSooksung()) {
			return -1;
		} else {
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {
					if (box[r][c] > max) {
						max = box[r][c];
					}
				}
			}
			return max - 1;
		}
	}
}
