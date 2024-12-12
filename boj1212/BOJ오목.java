package boj.boj1212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


// 16096 KB
// 120 MS
public class BOJ오목 {
	static StringTokenizer tokens;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map = new int[19][19]; // 오목판
	static int[][] deltas = { {0, 1}, {1, 1}, {-1, 1}, {1, 0} };
	static boolean[][][] visited = new boolean[19][19][4];

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 19; i++) {
			tokens = new StringTokenizer(input.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (map[i][j] == 1 || map[i][j] == 2) {
					for (int d = 0; d < 4; d++) {
						if (!visited[i][j][d] && findFive(i, j, d, map[i][j])) {
							System.out.println(map[i][j]);
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
					}
				}
			}
		}
		System.out.println(0); // 승부가 결정되지 않음
	}

	static boolean findFive(int x, int y, int d, int color) {
		int cnt = 1;
		int nx = x;
		int ny = y;

		while (cnt < 5) {
			nx += deltas[d][0];
			ny += deltas[d][1];
			if (!check(nx, ny) || map[nx][ny] != color) return false;
			cnt++;
			visited[nx][ny][d] = true;
		}

		// 앞
		nx = x - deltas[d][0];
		ny = y - deltas[d][1];
		if (check(nx, ny) && map[nx][ny] == color) return false;

		// 뒤
		nx = x + 5 * deltas[d][0];
		ny = y + 5 * deltas[d][1];
		if (check(nx, ny) && map[nx][ny] == color) return false;

		return true;
	}

	static boolean check(int x, int y) {
		return x >= 0 && x < 19 && y >= 0 && y < 19;
	}
}
