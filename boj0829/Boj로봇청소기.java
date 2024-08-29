package boj0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//14480	kb
//104 ms
public class Boj로봇청소기 {
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	private static int n, m, direction, res = 0;
	private static int[][] map;
	private static int[] robot;

	private static int deltas[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북동남서

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		// 0은 청소되지 않은 것 1은 벽이 있는 것
		n = Integer.parseInt(tokens.nextToken());
		m = Integer.parseInt(tokens.nextToken());
		map = new int[n][m];
		robot = new int[2];
		tokens = new StringTokenizer(input.readLine());
		robot[0] = Integer.parseInt(tokens.nextToken());
		robot[1] = Integer.parseInt(tokens.nextToken());
		direction = Integer.parseInt(tokens.nextToken());

		for (int i = 0; i < n; i++) {
			tokens = new StringTokenizer(input.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}

		int x = robot[0];
		int y = robot[1];

		while (true) {
			if (map[x][y] == 0) { // 현재칸 청소 할 수 있는 경우
				map[x][y] = -1; // 청소 완료
				res++;
			}
			// 4칸 체크
			boolean flag = check(x, y);
			// 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 없는 경우
			if (!flag) {
				int nx = x - deltas[direction][0];
				int ny = y - deltas[direction][1];

				// 현재에서 후진할 수 있으면 후진
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 1) {
					x = nx;
					y = ny;
				} else {
					break; // 작동 멈추기
				}
			}
			// 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 있는 경우
			else {
				turn(); // 90도 반시계 회전
				int nx = x + deltas[direction][0];
				int ny = y + deltas[direction][1];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) { // 빈칸이 있는 경우 한칸 전진
					x = nx;
					y = ny;
				}
			}
		}
		System.out.print(res);
	}

	private static boolean check(int a, int b) {
		// 현재 칸의 주변 4칸 중 청소할 수 있는 빈칸이 하나라도 있는 경우
		for (int i = 0; i < 4; i++) {
			int nx = a + deltas[i][0];
			int ny = b + deltas[i][1];
			if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
				return true;
			}
		}
		return false;
	}

	private static void turn() {
		direction = (direction - 1 + 4) % 4;
	}
}
