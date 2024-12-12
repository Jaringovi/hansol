package boj.boj1212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ오목 {
	static StringTokenizer tokens;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int [][] map = new int[19][19]; //오목판
	static int [][] deltas = { {0,1}, {1,1}, {-1,1}, {1,0}, {0,-1}, {-1,-1}, {1,-1}, {-1,0} };
	static boolean[][][] visited = new boolean[19][19][8];
	static Queue<int[]> deque = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 19; i++) {
			tokens = new StringTokenizer(input.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
				if (map[i][j] == 1 || map[i][j] == 2) {
					deque.add(new int[] {i, j});
				}
			}
		}

		while (!deque.isEmpty()) {
			int[] t = deque.poll();
			int x = t[0];
			int y = t[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + deltas[i][0];
				int ny = y + deltas[i][1];
				if (!check(nx, ny))
					continue;
				if (!visited[nx][ny][i] && findFive(nx, ny, i, map[x][y])) {
					if (!check(x + deltas[i + 4][0], y + deltas[i + 4][1])) {
						System.out.println(map[x][y]);
						System.out.println((x + 1) + " " + (y + 1));
						return;
					}
					if(check(x+deltas[i+4][0], y+deltas[i+4][1]) && map[x + deltas[i+4][0]][y + deltas[i+4][1]] != map[nx][ny]) {
						System.out.println(map[x][y]);
						System.out.println((x + 1) + " " + (y + 1));
						return;
					}
				}
			}
		}
	}

	//5개만 체크
	static boolean findFive(int x, int y, int d, int c) {
		if(c == 0) return false; //비었을 때
		int cnt = 1;
		while (map[x][y] == c) {
			cnt++;
			visited[x][y][d] = true;
			x+=deltas[d][0];
			y+=deltas[d][1];
		}
		if(cnt == 5) return true;
		return false;
	}
	static boolean check(int x, int y) {
		return x>=0 && x<19 && y>=0 && y<19;
	}
}
